package com.prueba.movies.app.dagger

import android.content.Context
import com.prueba.movies.app.dagger.module.AppModule
import com.prueba.movies.app.dagger.module.ContextModule
import com.prueba.movies.app.dagger.module.GsonModule
import com.prueba.movies.app.dagger.module.NetworkModule
import com.prueba.movies.app.network.MoviesNetwork
import dagger.Component

/**
 * interface que contiene las dependencia que se van a inyectar en la apicacclion
 * igual que lo metodos que se van a inyectar
 */
@AppScope
@Component(modules = arrayOf(AppModule::class, ContextModule::class, NetworkModule::class, GsonModule::class))
interface AppComponent {
    fun context(): Context
    fun network(): MoviesNetwork
}
