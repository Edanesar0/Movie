package co.com.smartquick.smarttickets.adapters.ticket.dagger

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.com.smartquick.smarttickets.R
import co.com.smartquick.smarttickets.adapters.ticket.mvp.TicketAdapterModel
import co.com.smartquick.smarttickets.adapters.ticket.mvp.TicketAdapterPresenter
import co.com.smartquick.smarttickets.adapters.ticket.mvp.TicketViewHolder
import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import co.com.smartquick.smarttickets.entities.Ticket
import dagger.Module
import dagger.Provides

@Module
class TicketAdapterModule(val activity: Activity, val recyclerView: ViewGroup, val items: List<Ticket>) {

    @Provides
    @TicketAdapterScope
    fun view(): View {
        return LayoutInflater.from(activity).inflate(R.layout.card_tickets, recyclerView, false)

    }

    @Provides
    @TicketAdapterScope
    fun ticketsHolder(view: View): TicketViewHolder {
        return TicketViewHolder(view, items, activity)
    }

    @Provides
    @TicketAdapterScope
    fun model(network: SmartTicketsNetwork): TicketAdapterModel {
        return TicketAdapterModel(network)
    }

    @Provides
    @TicketAdapterScope
    fun presenter(view: TicketViewHolder, model: TicketAdapterModel): TicketAdapterPresenter {
        return TicketAdapterPresenter(view, model)
    }
}