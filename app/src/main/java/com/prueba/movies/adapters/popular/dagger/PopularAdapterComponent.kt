package com.prueba.movies.adapters.popular.dagger

import com.prueba.movies.adapters.popular.PopularAdapter
import com.prueba.movies.app.dagger.AppComponent
import dagger.Component

@PopularAdapterScope
@Component(modules = arrayOf(PopularAdapterModule::class), dependencies = [(AppComponent::class)])
interface PopularAdapterComponent {
    fun inject(popularAdapter: PopularAdapter)
}