package co.com.smartquick.smarttickets.activities.home.mvp

import io.reactivex.disposables.CompositeDisposable

class HomePresenter(private val view: HomeView, private val model: HomeModel) {
    private val disposable = CompositeDisposable()

    fun onCreate() {
//        disposable.add(buttonClickLogin())
//        disposable.add(buttonClickCrearCuenta())
    }

    fun onDestroy() {
        disposable.clear()
    }
}
