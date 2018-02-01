package com.prueba.movies.activities.home.dagger

import android.app.Activity
import com.prueba.movies.activities.home.mvp.HomeModel
import com.prueba.movies.activities.home.mvp.HomePresenter
import com.prueba.movies.activities.home.mvp.HomeView
import com.prueba.movies.app.network.MoviesNetwork
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule(private val activity: Activity) {
    @Provides
    @HomeActivityScope
    fun view(): HomeView {
        return HomeView(activity)
    }

    @Provides
    @HomeActivityScope
    fun model(network: MoviesNetwork): HomeModel {
        return HomeModel(network)
    }

    @Provides
    @HomeActivityScope
    fun presenter(view: HomeView, model: HomeModel): HomePresenter {
        return HomePresenter(view, model)
    }
}