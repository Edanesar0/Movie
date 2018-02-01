package com.prueba.movies.fragments.top.dagger

import com.prueba.movies.app.dagger.AppComponent
import com.prueba.movies.fragments.top.FragmentTop
import dagger.Component

@FragmentTopScope
@Component(modules = arrayOf(FragmentTopModule::class), dependencies = [(AppComponent::class)])
interface FragmentTopComponent {
    fun inject(fragmentTop: FragmentTop)
}
