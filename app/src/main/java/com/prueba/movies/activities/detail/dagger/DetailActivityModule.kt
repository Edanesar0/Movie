package com.prueba.movies.activities.detail.dagger

import android.app.Activity
import com.prueba.movies.activities.detail.mvp.DetailModel
import com.prueba.movies.activities.detail.mvp.DetailPresenter
import com.prueba.movies.activities.detail.mvp.DetailView

import com.prueba.movies.app.network.MoviesNetwork
import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule(private val activity: Activity) {
    @Provides
    @DetailActivityScope
    fun view(): DetailView {
        return DetailView(activity)
    }

    @Provides
    @DetailActivityScope
    fun model(network: MoviesNetwork): DetailModel {
        return DetailModel(network)
    }

    @Provides
    @DetailActivityScope
    fun presenter(view: DetailView, model: DetailModel): DetailPresenter {
        return DetailPresenter(view, model)
    }
}