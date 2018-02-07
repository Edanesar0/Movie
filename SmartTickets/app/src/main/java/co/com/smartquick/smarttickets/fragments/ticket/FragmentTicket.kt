package co.com.smartquick.smarttickets.fragments.ticket

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.com.smartquick.smarttickets.app.SmartTicketsApplication
import co.com.smartquick.smarttickets.fragments.ticket.dagger.DaggerFragmentTicketComponent
import co.com.smartquick.smarttickets.fragments.ticket.dagger.FragmentTicketModule
import co.com.smartquick.smarttickets.fragments.ticket.mvp.FragmentTicketPresenter
import co.com.smartquick.smarttickets.fragments.ticket.mvp.FragmentTicketView
import javax.inject.Inject

class FragmentTicket : Fragment() {

    @Inject
    lateinit var ticketsView: FragmentTicketView
    @Inject
    lateinit var ticketsPresenter: FragmentTicketPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerFragmentTicketComponent
                .builder()
                .fragmentTicketModule(FragmentTicketModule(activity))
                .appComponent(SmartTicketsApplication[activity].component())
                .build().inject(this)
        ticketsPresenter.onCreate()
        return ticketsView
    }

    override fun onDestroy() {
        ticketsPresenter.onDestroy()
        super.onDestroy()
    }
}