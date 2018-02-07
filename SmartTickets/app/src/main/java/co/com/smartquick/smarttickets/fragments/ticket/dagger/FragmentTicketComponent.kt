package co.com.smartquick.smarttickets.fragments.ticket.dagger

import co.com.smartquick.smarttickets.app.dagger.AppComponent
import co.com.smartquick.smarttickets.fragments.ticket.FragmentTicket
import dagger.Component

@FragmentTicketScope
@Component(modules = arrayOf(FragmentTicketModule::class), dependencies = arrayOf(AppComponent::class))
interface FragmentTicketComponent {
    fun inject(fragmentTicket: FragmentTicket)
}
