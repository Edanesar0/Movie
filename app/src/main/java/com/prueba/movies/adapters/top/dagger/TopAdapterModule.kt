package com.prueba.movies.adapters.top.dagger

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prueba.movies.R
import com.prueba.movies.adapters.top.mvp.TopAdapterModel
import com.prueba.movies.adapters.top.mvp.TopAdapterPresenter
import com.prueba.movies.adapters.top.mvp.TopViewHolder
import com.prueba.movies.app.network.MoviesNetwork
import com.prueba.movies.entities.Movie
import dagger.Module
import dagger.Provides

@Module
class TopAdapterModule(val activity: Activity, val recyclerView: ViewGroup, val items: List<Movie>) {

    @Provides
    @TopAdapterScope
    fun view(): View {
        return LayoutInflater.from(activity).inflate(R.layout.card_movies, recyclerView, false)

    }

    @Provides
    @TopAdapterScope
    fun topHolder(view: View): TopViewHolder {
        return TopViewHolder(view, items, activity)
    }

    @Provides
    @TopAdapterScope
    fun model(network: MoviesNetwork): TopAdapterModel {
        return TopAdapterModel(network)
    }

    @Provides
    @TopAdapterScope
    fun presenter(view: TopViewHolder, model: TopAdapterModel): TopAdapterPresenter {
        return TopAdapterPresenter(view, model)
    }
}