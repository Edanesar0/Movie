package com.prueba.movies.adapters.top.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class TopAdapterPresenter(val view: TopViewHolder, val model: TopAdapterModel) {
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