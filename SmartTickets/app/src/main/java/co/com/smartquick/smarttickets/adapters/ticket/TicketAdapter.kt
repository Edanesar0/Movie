package co.com.smartquick.smarttickets.adapters.ticket

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import co.com.smartquick.smarttickets.adapters.ticket.dagger.DaggerTicketAdapterComponent
import co.com.smartquick.smarttickets.adapters.ticket.dagger.TicketAdapterModule
import co.com.smartquick.smarttickets.adapters.ticket.mvp.TicketAdapterPresenter
import co.com.smartquick.smarttickets.adapters.ticket.mvp.TicketViewHolder
import co.com.smartquick.smarttickets.app.SmartTicketsApplication
import co.com.smartquick.smarttickets.entities.Ticket
import javax.inject.Inject

class TicketAdapter(val activity: Activity, val items: List<Ticket>) : RecyclerView.Adapter<TicketViewHolder>() {

    @Inject
    lateinit var presenter: TicketAdapterPresenter
    @Inject
    lateinit var view: TicketViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder? {
        DaggerTicketAdapterComponent.builder()
                .appComponent(SmartTicketsApplication[activity].component())
                .ticketAdapterModule(TicketAdapterModule(activity, parent, items))
                .build()
                .inject(this)
        presenter.onCreate()
        return view
    }


    override fun onBindViewHolder(holder: TicketViewHolder?, position: Int) {
        if (holder != null) {
            holder.txtProyecto?.text = items.get(position).idproyecto?.get(0)?.nombre
            holder.txtAsignado?.text = items.get(position).idquienpide?.nombre
            holder.txtNombre?.text = items.get(position).idresponsable?.nombre
            holder.txtFecha?.text = items.get(position).fechainicio
            holder.txtEstado?.text = items.get(position).idestado?.descripcion


        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}