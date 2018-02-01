package com.prueba.movies.fragments.popular.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class FragmentPopularPresenter(val view: FragmentPopularView, val model: FragmentPopularModel) {
    private val disposable = CompositeDisposable()
    fun onCreate() {
        disposable.add(loadData())
    }

    fun onDestroy() {
        disposable.clear()
    }

    fun loadData(): Disposable {
        return view.onEnterView()
                .observeOn(AndroidSchedulers.mainThread())
                .map { model.loadData() }
                .subscribe({ view.cargarDatosRecicler(it) })

    }
}