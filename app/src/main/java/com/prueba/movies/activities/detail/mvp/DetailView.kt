package com.prueba.movies.activities.detail.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import com.jakewharton.rxbinding2.view.RxView
import com.prueba.movies.R
import com.prueba.movies.activities.detail.DetailActivity
import com.prueba.movies.entities.Movie
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.content_detail.view.*


@SuppressLint("ViewConstructor")
class DetailView(val activity: Activity) : FrameLayout(activity) {
    init {
        View.inflate(context, R.layout.activity_detail, this)

    }

    fun getIdentificador(): Int {
        return (activity as DetailActivity).getIds()
    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }

    fun loadData(movie: Movie?) {
        toolbar_layout.title = movie?.title
        toolbar_layout.title
        txtTitulo.text = movie?.original_title
        txtFechaEstreno.text = movie?.release_date
        txtIdioma.text = movie?.original_language
        txtDescripcion.text = movie?.overview
        cargarImagen(imgBanner, movie?.backdrop_path)
    }

    @Throws(Exception::class)
    fun cargarImagen(view: ImageView, url: String?) {
        Picasso.with(activity)
                .load("https://image.tmdb.org/t/p/w600" + url)
                .into(view)


    }
}
