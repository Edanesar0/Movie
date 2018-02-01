package com.prueba.movies.activities.splash.dagger

import com.prueba.movies.activities.splash.SplashActivity
import com.prueba.movies.app.dagger.AppComponent
import dagger.Component

@SplashActivityScope
@Component(modules = arrayOf(SplashActivityModule::class), dependencies = [(AppComponent::class)])
interface SplashActivityComponent {
    fun inject(splashActivity: SplashActivity)

}
