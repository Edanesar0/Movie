package com.prueba.movies.fragments.popular.dagger

import com.prueba.movies.app.dagger.AppComponent
import com.prueba.movies.fragments.popular.FragmentPopular
import dagger.Component

@FragmentPopularScope
@Component(modules = arrayOf(FragmentPopularModule::class), dependencies = [(AppComponent::class)])
interface FragmentPopularComponent {
    fun inject(fragmentPopular: FragmentPopular)
}