package com.prueba.movies.fragments.popular.dagger

import android.app.Activity
import com.prueba.movies.app.network.MoviesNetwork
import com.prueba.movies.fragments.popular.mvp.FragmentPopularModel
import com.prueba.movies.fragments.popular.mvp.FragmentPopularPresenter
import com.prueba.movies.fragments.popular.mvp.FragmentPopularView
import dagger.Module
import dagger.Provides

@Module
class FragmentPopularModule(private val activity: Activity) {


    @Provides
    @FragmentPopularScope
    fun view(): FragmentPopularView {
        return FragmentPopularView(activity)
    }

    @Provides
    @FragmentPopularScope
    fun model(network: MoviesNetwork): FragmentPopularModel {
        return FragmentPopularModel(network)
    }

    @Provides
    @FragmentPopularScope
    fun presenter(view: FragmentPopularView, model: FragmentPopularModel): FragmentPopularPresenter {
        return FragmentPopularPresenter(view, model)
    }

}
