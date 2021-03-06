package co.com.smartquick.smarttickets.fragments.proyecto.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class FragmentProyectoPresenter(val view: FragmentProyectoView, val model: FragmentProyectoModel) {
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