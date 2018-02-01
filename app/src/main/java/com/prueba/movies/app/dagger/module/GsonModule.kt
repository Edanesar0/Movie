package com.prueba.movies.app.dagger.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.prueba.movies.app.dagger.AppScope
import dagger.Module
import dagger.Provides

@Module
/**
 * Modulo encargado convertir datos string en
 * POJOS gson
 */
class GsonModule {

    @AppScope
    @Provides
    fun gson(): Gson {
        return GsonBuilder()
                .serializeNulls()
                .create()
    }
}
