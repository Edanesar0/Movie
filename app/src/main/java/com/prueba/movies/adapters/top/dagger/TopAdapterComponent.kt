package com.prueba.movies.adapters.top.dagger

import com.prueba.movies.adapters.top.TopAdapter
import com.prueba.movies.app.dagger.AppComponent
import dagger.Component

@TopAdapterScope
@Component(modules = arrayOf(TopAdapterModule::class), dependencies = [(AppComponent::class)])
interface TopAdapterComponent {
    fun inject(topAdapter: TopAdapter)
}