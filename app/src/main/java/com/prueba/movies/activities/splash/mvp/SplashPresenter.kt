package com.prueba.movies.activities.splash.mvp

import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SplashPresenter(private val view: SplashView, private val model: SplashModel) {
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
                .subscribe({ disposable.add(getTop()) })
    }

    private fun getTop(): Disposable {
        return model.loadTop("33b17ab57b26981fc9b738094617084d", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ top ->
                    disposable.add(saveTop(top))
                }, { throwable ->
                    Log.e("observer", throwable.toString())
                }
                )
    }

    private fun getPopular(): Disposable {
        return model.loadPopular("33b17ab57b26981fc9b738094617084d", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ popular ->
                    disposable.add(savePopular(popular))
                }, { throwable ->
                    Log.e("observer", throwable.toString())
                }
                )
    }

    private fun saveTop(top: String): Disposable {
        return model.saveTopRealm(top)?.subscribe({
            if (it != null) {
                disposable.add(getPopular())
            } else {
                Toast.makeText(view.context, "No se pudo guardar el top ", Toast.LENGTH_LONG).show()
            }
        }, { throwable ->
            Toast.makeText(view.context, "" + throwable, Toast.LENGTH_LONG).show()
            Log.e("observer", throwable.toString())
        }
        )!!
    }

    private fun savePopular(popular: String): Disposable {
        return model.savePopularRealm(popular)?.subscribe({
            if (it != null) {
                view.changeActivity()
            } else {
                Toast.makeText(view.context, "No se pudo guardar los popular ", Toast.LENGTH_LONG).show()
            }
        }, { throwable ->
            Toast.makeText(view.context, "" + throwable, Toast.LENGTH_LONG).show()
            Log.e("observer", throwable.toString())
        }
        )!!
    }
}
