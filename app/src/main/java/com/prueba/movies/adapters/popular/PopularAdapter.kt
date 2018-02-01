package com.prueba.movies.adapters.popular

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import com.prueba.movies.adapters.popular.dagger.DaggerPopularAdapterComponent
import com.prueba.movies.adapters.popular.dagger.PopularAdapterModule
import com.prueba.movies.adapters.popular.mvp.PopularAdapterPresenter
import com.prueba.movies.adapters.popular.mvp.PopularViewHolder
import com.prueba.movies.app.MoviesApplication
import com.prueba.movies.entities.Movie
import com.squareup.picasso.Picasso
import javax.inject.Inject

class PopularAdapter(val activity: Activity, val items: List<Movie>) : RecyclerView.Adapter<PopularViewHolder>() {


    @Inject
    lateinit var presenter: PopularAdapterPresenter
    @Inject
    lateinit var view: PopularViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder? {
        DaggerPopularAdapterComponent
                .builder()
                .appComponent(MoviesApplication[activity].component())
                .popularAdapterModule(PopularAdapterModule(activity, parent, items))
                .build()
                .inject(this)

        presenter.onCreate()
        return view
    }


    override fun onBindViewHolder(holder: PopularViewHolder?, position: Int) {
        if (holder != null) {
            holder.txtNombre?.text = items[position].title
            holder.txtTitulo?.text = items[position].original_title
            holder.txtFechaEstreno?.text = items[position].release_date
            cargarImagen(holder.imgPoster, items[position].poster_path)
            holder.txtID?.text = items[position].id.toString()
        }
    }

    fun cargarImagen(imageView: ImageView, url: String?) {
        Picasso.with(activity)
                .load("https://image.tmdb.org/t/p/w300/" + url)
                .into(imageView)

    }

    override fun getItemCount(): Int {
        return items.size
    }
}