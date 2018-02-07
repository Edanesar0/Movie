package co.com.smartquick.smarttickets.fragments.ticket.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.FrameLayout
import co.com.smartquick.smarttickets.R
import co.com.smartquick.smarttickets.adapters.ticket.TicketAdapter
import co.com.smartquick.smarttickets.entities.Ticket
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_main.view.*

@SuppressLint("ViewConstructor")
class FragmentTicketView(val activity: Activity) : FrameLayout(activity) {
    init {
        View.inflate(context, R.layout.fragment_main, this)
    }

    fun cargarDatosRecicler(lista: List<Ticket>) {
        val linear = LinearLayoutManager(activity)
        rootView.reciclereTicket.layoutManager = linear
        rootView.reciclereTicket.adapter = TicketAdapter(activity, lista)
    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }
}