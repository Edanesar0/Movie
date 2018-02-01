package com.prueba.movies.activities.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.prueba.movies.activities.search.dagger.DaggerSearchActivityComponent
import com.prueba.movies.activities.search.dagger.SearchActivityModule
import com.prueba.movies.activities.search.mvp.SearchActivityPresenter
import com.prueba.movies.activities.search.mvp.SearchActivityView
import com.prueba.movies.app.MoviesApplication
import javax.inject.Inject

@SuppressLint("Registered")
class SearchActivity : AppCompatActivity() {

    @Inject
    lateinit var searchActivityView: SearchActivityView
    @Inject
    lateinit var searchActivityPresenter: SearchActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSearchActivityComponent
                .builder()
                .searchActivityModule(SearchActivityModule(this))
                .appComponent(MoviesApplication[this].component())
                .build().inject(this)
        setContentView(searchActivityView)
        searchActivityPresenter.onCreate()
    }

    override fun onDestroy() {
        searchActivityPresenter.onDestroy()
        super.onDestroy()
    }
}