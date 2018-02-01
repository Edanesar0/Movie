package com.prueba.movies.fragments.popular

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prueba.movies.app.MoviesApplication
import com.prueba.movies.fragments.popular.dagger.DaggerFragmentPopularComponent
import com.prueba.movies.fragments.popular.dagger.FragmentPopularModule
import com.prueba.movies.fragments.popular.mvp.FragmentPopularPresenter
import com.prueba.movies.fragments.popular.mvp.FragmentPopularView
import javax.inject.Inject

class FragmentPopular : Fragment() {

    @Inject
    lateinit var popularView: FragmentPopularView
    @Inject
    lateinit var popularPresenter: FragmentPopularPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerFragmentPopularComponent
                .builder()
                .fragmentPopularModule(FragmentPopularModule(activity))
                .appComponent(MoviesApplication[activity].component())
                .build().inject(this)
        popularPresenter.onCreate()
        return popularView
    }

    override fun onDestroy() {
        popularPresenter.onDestroy()
        super.onDestroy()
    }
}