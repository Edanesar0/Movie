package co.com.smartquick.smarttickets.adapters.ticket.mvp

import io.reactivex.disposables.CompositeDisposable

class TicketAdapterPresenter(val view: TicketViewHolder, val model: TicketAdapterModel) {
    private val disposable = CompositeDisposable()

    fun onCreate() {
//        disposable.add(buttonClickCrearCuenta())
    }

    fun onDestroy() {
        disposable.clear()
    }
}