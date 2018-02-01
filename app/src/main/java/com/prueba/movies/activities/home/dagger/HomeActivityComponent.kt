package com.prueba.movies.activities.home.dagger

import com.prueba.movies.activities.home.HomeActivity
import com.prueba.movies.app.dagger.AppComponent
import dagger.Component

@HomeActivityScope
@Component(modules = arrayOf(HomeActivityModule::class), dependencies = [(AppComponent::class)])
interface HomeActivityComponent {
    fun injectHomeActivity(homeActivity: HomeActivity)

}
