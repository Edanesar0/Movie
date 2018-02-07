package co.com.smartquick.smarttickets.adapters.proyectos.dagger

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.com.smartquick.smarttickets.R
import co.com.smartquick.smarttickets.adapters.proyectos.mvp.ProyectoAdapterModel
import co.com.smartquick.smarttickets.adapters.proyectos.mvp.ProyectoAdapterPresenter
import co.com.smartquick.smarttickets.adapters.proyectos.mvp.ProyectoViewHolder
import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import co.com.smartquick.smarttickets.entities.Proyecto
import dagger.Module
import dagger.Provides

@Module
class ProyectoAdapterModule(val activity: Activity, val recyclerView: ViewGroup, val items: List<Proyecto>) {

    @Provides
    @ProyectoAdapterScope
    fun view(): View {
        return LayoutInflater.from(activity).inflate(R.layout.card_tickets, recyclerView, false)

    }

    @Provides
    @ProyectoAdapterScope
    fun ticketsHolder(view: View): ProyectoViewHolder {
        return ProyectoViewHolder(view, items, activity)
    }

    @Provides
    @ProyectoAdapterScope
    fun model(network: SmartTicketsNetwork): ProyectoAdapterModel {
        return ProyectoAdapterModel(network)
    }

    @Provides
    @ProyectoAdapterScope
    fun presenter(view: ProyectoViewHolder, model: ProyectoAdapterModel): ProyectoAdapterPresenter {
        return ProyectoAdapterPresenter(view, model)
    }
}