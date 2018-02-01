package com.prueba.movies.app.dagger.module

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.prueba.movies.app.dagger.AppScope
import com.prueba.movies.app.dagger.qualifiers.ApplicationContext
import com.prueba.movies.app.ext.Constants
import com.prueba.movies.app.network.MoviesNetwork
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File

@Module
/***
 * Modulo encargado de la conectividad
 * incopora retorfit con la url base
 */
class NetworkModule {
    @AppScope
    @Provides
    fun cache(@ApplicationContext context: Context): Cache {
        return Cache(File(context.cacheDir, Constants.HTTP_CACHE_DIR),
                Constants.HTTP_CACHE_SIZE.toLong())
    }

    @AppScope
    @Provides
    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build()
    }

    @AppScope
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor { message -> Log.d("HTTPError ", message) }
        return logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    @AppScope
    @Provides
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.themoviedb.org/3/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @AppScope
    @Provides
    fun movieNetwork(retrofit: Retrofit): MoviesNetwork {
        return retrofit.create(MoviesNetwork::class.java)
    }
}
