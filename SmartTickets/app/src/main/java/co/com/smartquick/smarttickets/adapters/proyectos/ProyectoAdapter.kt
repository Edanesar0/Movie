package co.com.smartquick.smarttickets.adapters.proyectos

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import co.com.smartquick.smarttickets.adapters.proyectos.dagger.DaggerProyectoAdapterComponent
import co.com.smartquick.smarttickets.adapters.proyectos.dagger.ProyectoAdapterModule
import co.com.smartquick.smarttickets.adapters.proyectos.mvp.ProyectoAdapterPresenter
import co.com.smartquick.smarttickets.adapters.proyectos.mvp.ProyectoViewHolder
import co.com.smartquick.smarttickets.app.SmartTicketsApplication
import co.com.smartquick.smarttickets.entities.Proyecto
import javax.inject.Inject

class ProyectoAdapter(val activity: Activity, val items: List<Proyecto>) : RecyclerView.Adapter<ProyectoViewHolder>() {


    @Inject
    lateinit var presenter: ProyectoAdapterPresenter
    @Inject
    lateinit var view: ProyectoViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProyectoViewHolder? {
        DaggerProyectoAdapterComponent
                .builder()
                .appComponent(SmartTicketsApplication[activity].component())
                .proyectoAdapterModule(ProyectoAdapterModule(activity, parent, items))
                .build()
                .inject(this)

        presenter.onCreate()
        return view
    }


    override fun onBindViewHolder(holder: ProyectoViewHolder?, position: Int) {
        if (holder != null) {
            holder.txtProyecto?.text = items.get(position).nombre
            holder.txtAsignado?.text = items.get(position).color
            holder.txtNombre?.text = items.get(position).idproyecto.toString()
            /*holder.txtFecha?.text = items.get(position).fechainicio*/
            holder.txtEstado?.text = items.get(position).idestado?.descripcion

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}