package com.prueba.movies.activities.detail.mvp

import com.prueba.movies.app.network.MoviesNetwork
import com.prueba.movies.entities.Movie
import io.realm.Realm


class DetailModel(private val network: MoviesNetwork) {
    fun loadMovie(id: Int): Movie? {
        val movie: Movie?
        val realm: Realm = Realm.getDefaultInstance()
        movie = realm.where(Movie::class.java).equalTo("id", id).findFirst()
        return movie
    }
}