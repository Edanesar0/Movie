package com.prueba.movies.app.dagger.module

import android.app.Application
import android.content.Context
import com.prueba.movies.app.MoviesApplication
import com.prueba.movies.app.dagger.AppScope
import dagger.Module
import dagger.Provides

/***
 * Clase encargada de proveer informacion
 * El cual contiene informacion o datos puros que
 * se desee inyectar
 */
@Module
class AppModule(private val application: MoviesApplication) {
    private val context: Context

    init {
        this.context = application.applicationContext
    }

    @Provides
    @AppScope
    fun application(): Application {
        return application
    }

    @AppScope
    @Provides
    fun context(): Context {
        return context
    }

}
