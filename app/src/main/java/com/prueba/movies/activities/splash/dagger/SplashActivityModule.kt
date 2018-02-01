package com.prueba.movies.activities.splash.dagger

import android.app.Activity
import com.prueba.movies.activities.splash.mvp.SplashModel
import com.prueba.movies.activities.splash.mvp.SplashPresenter
import com.prueba.movies.activities.splash.mvp.SplashView
import com.prueba.movies.app.network.MoviesNetwork
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule(private val activity: Activity) {
    @Provides
    @SplashActivityScope
    fun view(): SplashView {
        return SplashView(activity)
    }

    @Provides
    @SplashActivityScope
    fun model(network: MoviesNetwork): SplashModel {
        return SplashModel(network)
    }

    @Provides
    @SplashActivityScope
    fun presenter(view: SplashView, model: SplashModel): SplashPresenter {
        return SplashPresenter(view, model)
    }
}