package com.prueba.movies.activities.search.dagger

import android.app.Activity
import com.prueba.movies.activities.search.mvp.SearchActivityModel
import com.prueba.movies.activities.search.mvp.SearchActivityPresenter
import com.prueba.movies.activities.search.mvp.SearchActivityView
import com.prueba.movies.app.network.MoviesNetwork
import dagger.Module
import dagger.Provides

@Module
class SearchActivityModule(private val activity: Activity) {


    @Provides
    @SearchActivityScope
    fun view(): SearchActivityView {
        return SearchActivityView(activity)
    }

    @Provides
    @SearchActivityScope
    fun model(network: MoviesNetwork): SearchActivityModel {
        return SearchActivityModel(network)
    }

    @Provides
    @SearchActivityScope
    fun presenter(activityView: SearchActivityView, activityModel: SearchActivityModel): SearchActivityPresenter {
        return SearchActivityPresenter(activityView, activityModel)
    }

}
