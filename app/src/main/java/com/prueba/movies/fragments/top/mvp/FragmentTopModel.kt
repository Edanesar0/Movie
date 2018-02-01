package com.prueba.movies.fragments.top.mvp

import com.prueba.movies.app.network.MoviesNetwork
import com.prueba.movies.entities.Movie
import com.prueba.movies.entities.Top
import io.realm.Realm
import io.realm.RealmResults

class FragmentTopModel(private val network: MoviesNetwork) {

    fun loadData(): List<Movie> {
        val lista: ArrayList<Movie> = ArrayList()
        val realm: Realm = Realm.getDefaultInstance()
        val tickets: RealmResults<Top> = realm.where(Top::class.java).findAll()
        for (variable in tickets) {
            variable.results?.forEach { movies ->
                if (movies != null) {
                    lista.add(movies)
                }
            }
        }
        return lista
    }
}