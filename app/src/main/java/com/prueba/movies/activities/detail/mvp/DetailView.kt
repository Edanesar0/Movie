package com.prueba.movies.activities.detail.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import com.jakewharton.rxbinding2.view.RxView
import com.prueba.movies.R
import com.prueba.movies.activities.detail.DetailActivity
import com.prueba.movies.entities.Movie
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
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
        (activity as DetailActivity).changeTitle(movie?.title)
        txtTitulo.text = movie?.original_title
        txtFechaEstreno.text = movie?.release_date
        txtIdioma.text = movie?.original_language
        txtDescripcion.text = movie?.overview
        cargarImagen(toolbar_layout, movie?.backdrop_path)
    }

    fun cargarImagen(view: View, url: String?) {
        Picasso.with(activity)
                .load("https://image.tmdb.org/t/p/w300/" + url)
                .into(object : Target {
                    override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {
                        view.background = BitmapDrawable(activity.resources, bitmap)
                    }

                    override fun onBitmapFailed(errorDrawable: Drawable) {
                        Log.d("TAG", "FAILED")
                    }

                    override fun onPrepareLoad(placeHolderDrawable: Drawable) {
                        Log.d("TAG", "Prepare Load")
                    }
                })


    }
}
