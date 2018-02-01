package com.prueba.movies.app.dagger.module

import android.content.Context
import com.prueba.movies.app.dagger.AppScope
import com.prueba.movies.app.dagger.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides

/**
 * Modulo encargado de devolver el contexto de la aplicacion
 */
@Module
class ContextModule(context: Context) {

    private val appContext: Context

    init {
        this.appContext = context.applicationContext
    }

    @Provides
    @AppScope
    @ApplicationContext
    fun context(): Context {
        return appContext
    }

}
