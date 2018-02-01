package com.prueba.movies.activities.search.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.FrameLayout
import com.jakewharton.rxbinding2.view.RxView
import com.prueba.movies.R
import com.prueba.movies.adapters.popular.PopularAdapter
import com.prueba.movies.entities.Movie
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_top.view.*

@SuppressLint("ViewConstructor")
class SearchActivityView(val activity: Activity) : FrameLayout(activity) {
    init {
        View.inflate(context, R.layout.fragment_top, this)
    }

    fun cargarDatosRecicler(lista: List<Movie>) {
        val linear = LinearLayoutManager(activity)
        rootView.reciclerTop.layoutManager = linear
        rootView.reciclerTop.adapter = PopularAdapter(activity, lista)
    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }
}