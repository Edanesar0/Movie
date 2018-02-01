package com.prueba.movies.activities.home.mvp

import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomePresenter(private val view: HomeView, private val model: HomeModel) {
    private val disposable = CompositeDisposable()

    fun onCreate() {
    }

    fun onDestroy() {
        disposable.clear()
    }

    fun onCreateMenu() {
        disposable.add(searchView())
    }

    private fun searchView(): Disposable {
        return view.searchViewChange()
                .subscribe { s ->
                    if (s.isSubmitted) {
                        onSearchQuery(s.queryText().toString())
                    }
                }
    }

    private fun onSearchQuery(term: String): Disposable {
        return model.search("33b17ab57b26981fc9b738094617084d", "1", term)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ popular ->
                    disposable.add(saveSearch(popular))
                }, { throwable ->
                    Log.e("observer", throwable.toString())
                }
                )
    }

    private fun saveSearch(search: String): Disposable {
        return model.saveSearchRealm(search)?.subscribe({
            if (it != null) {
                view.changeActivity()
            } else {
                Toast.makeText(view.context, "No se pudo guardar los search ", Toast.LENGTH_LONG).show()
            }
        }, { throwable ->
            Toast.makeText(view.context, "" + throwable, Toast.LENGTH_LONG).show()
            Log.e("observer", throwable.toString())
        }
        )!!
    }
}
