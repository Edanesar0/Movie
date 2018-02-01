package com.prueba.movies.activities.search.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class SearchActivityPresenter(val activityView: SearchActivityView, val activityModel: SearchActivityModel) {
    private val disposable = CompositeDisposable()
    fun onCreate() {
        disposable.add(loadData())
    }

    fun onDestroy() {
        disposable.clear()
    }

    fun loadData(): Disposable {
        return activityView.onEnterView()
                .observeOn(AndroidSchedulers.mainThread())
                .map { activityModel.loadData() }
                .subscribe({ activityView.cargarDatosRecicler(it) })

    }
}