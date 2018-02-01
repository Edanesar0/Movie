package com.prueba.movies.activities.splash.mvp

import com.prueba.movies.app.network.MoviesNetwork
import com.prueba.movies.entities.Popular
import com.prueba.movies.entities.Top
import io.reactivex.Observable
import io.realm.Realm


class SplashModel(private val network: MoviesNetwork) {
    fun loadPopular(api_key: String, page: String): Observable<String> {
        return network.sendPopular(api_key, "es-ES", page)
    }

    fun loadTop(api_key: String, page: String): Observable<String> {
        return network.sendTop(api_key, "es-ES", page)
    }

    fun saveTopRealm(top: String): Observable<Any?>? {
        return Observable.fromCallable {
            try {
                val realm = Realm.getDefaultInstance()
                var top1: Top? = null
                realm.executeTransaction({
                    top1 = realm.createOrUpdateObjectFromJson(Top::class.java, top)
                })
                return@fromCallable top1
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun savePopularRealm(popular: String): Observable<Any?>? {
        return Observable.fromCallable {
            try {
                val realm = Realm.getDefaultInstance()
                var pop: Popular? = null
                realm.executeTransaction({
                    pop = realm.createOrUpdateObjectFromJson(Popular::class.java, popular)
                })
                return@fromCallable pop
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}