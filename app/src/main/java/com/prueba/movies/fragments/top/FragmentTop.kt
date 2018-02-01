package com.prueba.movies.fragments.top

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prueba.movies.app.MoviesApplication
import com.prueba.movies.fragments.top.dagger.DaggerFragmentTopComponent
import com.prueba.movies.fragments.top.dagger.FragmentTopModule
import com.prueba.movies.fragments.top.mvp.FragmentTopPresenter
import com.prueba.movies.fragments.top.mvp.FragmentTopView
import javax.inject.Inject

class FragmentTop : Fragment() {

    @Inject
    lateinit var topView: FragmentTopView
    @Inject
    lateinit var topPresenter: FragmentTopPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerFragmentTopComponent
                .builder()
                .fragmentTopModule(FragmentTopModule(activity))
                .appComponent(MoviesApplication[activity].component())
                .build().inject(this)
        topPresenter.onCreate()
        return topView
    }

    override fun onDestroy() {
        topPresenter.onDestroy()
        super.onDestroy()
    }
}