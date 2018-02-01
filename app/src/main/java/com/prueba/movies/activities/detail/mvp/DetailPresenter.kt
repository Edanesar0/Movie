package com.prueba.movies.activities.detail.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class DetailPresenter(private val view: DetailView, private val model: DetailModel) {
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
                .map { model.loadMovie(view.getIdentificador()) }
                .subscribe({ view.loadData(it) })
    }

}
