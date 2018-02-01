package com.prueba.movies.adapters.popular.dagger

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prueba.movies.R
import com.prueba.movies.adapters.popular.mvp.PopularAdapterModel
import com.prueba.movies.adapters.popular.mvp.PopularAdapterPresenter
import com.prueba.movies.adapters.popular.mvp.PopularViewHolder
import com.prueba.movies.app.network.MoviesNetwork
import com.prueba.movies.entities.Movie
import dagger.Module
import dagger.Provides

@Module
class PopularAdapterModule(val activity: Activity, val recyclerView: ViewGroup, val items: List<Movie>) {

    @Provides
    @PopularAdapterScope
    fun view(): View {
        return LayoutInflater.from(activity).inflate(R.layout.card_movies, recyclerView, false)

    }

    @Provides
    @PopularAdapterScope
    fun popularHolder(view: View): PopularViewHolder {
        return PopularViewHolder(view, items, activity)
    }

    @Provides
    @PopularAdapterScope
    fun model(network: MoviesNetwork): PopularAdapterModel {
        return PopularAdapterModel(network)
    }

    @Provides
    @PopularAdapterScope
    fun presenter(view: PopularViewHolder, model: PopularAdapterModel): PopularAdapterPresenter {
        return PopularAdapterPresenter(view, model)
    }
}