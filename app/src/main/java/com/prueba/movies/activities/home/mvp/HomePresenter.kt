package com.prueba.movies.activities.home.mvp

import io.reactivex.disposables.CompositeDisposable

class HomePresenter(private val view: HomeView, private val model: HomeModel) {
    private val disposable = CompositeDisposable()

    fun onCreate() {
    }

    fun onDestroy() {
        disposable.clear()
    }
}
