package com.prueba.movies.activities.home.mvp

import com.prueba.movies.app.network.MoviesNetwork
import com.prueba.movies.entities.Search
import io.reactivex.Observable
import io.realm.Realm


class HomeModel(private val network: MoviesNetwork) {
    fun search(api_key: String, page: String, string: String): Observable<String> {
        return network.searchMovie(api_key, "es-ES", string, page, "false")
    }

    fun saveSearchRealm(s: String): Observable<Any?>? {
        return Observable.fromCallable {
            try {
                val realm = Realm.getDefaultInstance()
                var search: Search? = null
                realm.executeTransaction({
                    realm.delete(Search::class.java)
                    search = realm.createOrUpdateObjectFromJson(Search::class.java, s)
                })
                return@fromCallable search
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}