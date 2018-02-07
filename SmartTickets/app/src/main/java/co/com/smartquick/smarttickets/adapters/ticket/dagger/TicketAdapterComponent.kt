package co.com.smartquick.smarttickets.adapters.ticket.dagger

import co.com.smartquick.smarttickets.adapters.ticket.TicketAdapter
import co.com.smartquick.smarttickets.app.dagger.AppComponent
import dagger.Component

@TicketAdapterScope
@Component(modules = arrayOf(TicketAdapterModule::class), dependencies = [(AppComponent::class)])
interface TicketAdapterComponent {
    fun inject(ticketAdapter: TicketAdapter)
}