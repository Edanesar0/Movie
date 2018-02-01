package com.prueba.movies.fragments.top.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.FrameLayout
import com.jakewharton.rxbinding2.view.RxView
import com.prueba.movies.R
import com.prueba.movies.adapters.top.TopAdapter
import com.prueba.movies.entities.Movie
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_popular.view.*

@SuppressLint("ViewConstructor")
class FragmentTopView(val activity: Activity) : FrameLayout(activity) {
    init {
        View.inflate(context, R.layout.fragment_popular, this)
    }

    fun cargarDatosRecicler(lista: List<Movie>) {
        val linear = LinearLayoutManager(activity)
        rootView.reciclerePopular.layoutManager = linear
        rootView.reciclerePopular.adapter = TopAdapter(activity, lista)
    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }
}