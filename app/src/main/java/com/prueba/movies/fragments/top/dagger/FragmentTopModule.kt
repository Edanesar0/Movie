package com.prueba.movies.fragments.top.dagger

import android.app.Activity
import com.prueba.movies.app.network.MoviesNetwork
import com.prueba.movies.fragments.top.mvp.FragmentTopModel
import com.prueba.movies.fragments.top.mvp.FragmentTopPresenter
import com.prueba.movies.fragments.top.mvp.FragmentTopView
import dagger.Module
import dagger.Provides

@Module
class FragmentTopModule(private val activity: Activity) {


    @Provides
    @FragmentTopScope
    fun view(): FragmentTopView {
        return FragmentTopView(activity)
    }

    @Provides
    @FragmentTopScope
    fun model(network: MoviesNetwork): FragmentTopModel {
        return FragmentTopModel(network)
    }

    @Provides
    @FragmentTopScope
    fun presenter(view: FragmentTopView, model: FragmentTopModel): FragmentTopPresenter {
        return FragmentTopPresenter(view, model)
    }

}
