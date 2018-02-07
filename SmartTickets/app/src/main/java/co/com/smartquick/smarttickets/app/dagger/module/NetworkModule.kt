package co.com.smartquick.smarttickets.app.dagger.module

import android.content.Context
import android.util.Log
import co.com.smartquick.smarttickets.app.dagger.AppScope
import co.com.smartquick.smarttickets.app.dagger.qualifiers.ApplicationContext
import co.com.smartquick.smarttickets.app.ext.Constants
import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import co.com.smartquick.smarttickets.app.util.BasicAuthInterceptor
import com.google.gson.Gson
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
class NetworkModule {

    @AppScope
    @Provides
    fun cache(@ApplicationContext context: Context): Cache {
        return Cache(File(context.cacheDir, Constants.HTTP_CACHE_DIR),
                Constants.HTTP_CACHE_SIZE.toLong())
    }

    @AppScope
    @Provides
    fun okHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(BasicAuthInterceptor("admin", "admin"))
                .cache(cache)
                .build()
    }

    @AppScope
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor { Log.d("HTTPError ", it) }
        return logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    @AppScope
    @Provides
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://192.168.1.134/SmartTickets/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @AppScope
    @Provides
    fun ticketNetwork(retrofit: Retrofit): SmartTicketsNetwork {
        return retrofit.create(SmartTicketsNetwork::class.java)
    }
}
