package com.prueba.movies.adapters.top

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import com.prueba.movies.adapters.top.dagger.DaggerTopAdapterComponent
import com.prueba.movies.adapters.top.dagger.TopAdapterModule
import com.prueba.movies.adapters.top.mvp.TopAdapterPresenter
import com.prueba.movies.adapters.top.mvp.TopViewHolder
import com.prueba.movies.app.MoviesApplication
import com.prueba.movies.entities.Movie
import com.squareup.picasso.Picasso
import javax.inject.Inject

class TopAdapter(val activity: Activity, val items: List<Movie>) : RecyclerView.Adapter<TopViewHolder>() {

    @Inject
    lateinit var presenter: TopAdapterPresenter
    @Inject
    lateinit var view: TopViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder? {
        DaggerTopAdapterComponent.builder()
                .appComponent(MoviesApplication[activity].component())
                .topAdapterModule(TopAdapterModule(activity, parent, items))
                .build()
                .inject(this)
        presenter.onCreate()
        return view
    }


    override fun onBindViewHolder(holder: TopViewHolder?, position: Int) {
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