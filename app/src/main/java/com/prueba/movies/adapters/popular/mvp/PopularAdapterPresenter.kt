package com.prueba.movies.adapters.popular.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class PopularAdapterPresenter(val view: PopularViewHolder, val model: PopularAdapterModel) {
    private val disposable = CompositeDisposable()

    fun onCreate() {
        disposable.add(clickDetalles())
    }

    fun clickDetalles(): Disposable {
        return view.clickDetalle()
                .subscribe({ view.changeActivity() })
    }


    fun onDestroy() {
        disposable.clear()
    }
}