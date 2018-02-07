package co.com.smartquick.smarttickets.adapters.proyectos.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class ProyectoAdapterPresenter(val view: ProyectoViewHolder, val model: ProyectoAdapterModel) {
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