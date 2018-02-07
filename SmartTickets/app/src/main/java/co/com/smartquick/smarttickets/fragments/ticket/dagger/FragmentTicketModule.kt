package co.com.smartquick.smarttickets.fragments.ticket.dagger

import android.app.Activity
import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import co.com.smartquick.smarttickets.fragments.ticket.mvp.FragmentTicketModel
import co.com.smartquick.smarttickets.fragments.ticket.mvp.FragmentTicketPresenter
import co.com.smartquick.smarttickets.fragments.ticket.mvp.FragmentTicketView
import dagger.Module
import dagger.Provides

@Module
class FragmentTicketModule(private val activity: Activity) {


    @Provides
    @FragmentTicketScope
    fun view(): FragmentTicketView {
        return FragmentTicketView(activity)
    }

    @Provides
    @FragmentTicketScope
    fun model(network: SmartTicketsNetwork): FragmentTicketModel {
        return FragmentTicketModel(network)
    }

    @Provides
    @FragmentTicketScope
    fun presenter(view: FragmentTicketView, model: FragmentTicketModel): FragmentTicketPresenter {
        return FragmentTicketPresenter(view, model)
    }

}
