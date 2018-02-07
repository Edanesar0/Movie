package co.com.smartquick.smarttickets.adapters.proyectos.mvp

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import co.com.smartquick.smarttickets.R
import co.com.smartquick.smarttickets.activities.home.HomeActivity
import co.com.smartquick.smarttickets.entities.Proyecto
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable

class ProyectoViewHolder(itemView: View, val items: List<Proyecto>, val activity: Activity) : RecyclerView.ViewHolder(itemView) {
    val txtProyecto: TextView? = itemView.findViewById(R.id.txtProyecto)
    val txtAsignado: TextView? = itemView.findViewById(R.id.txtAsignado)
    val txtNombre: TextView? = itemView.findViewById(R.id.txtNombre)
    val txtFecha: TextView? = itemView.findViewById(R.id.txtFecha)
    val txtEstado: TextView? = itemView.findViewById(R.id.txtEstado)
    val cardTickets: CardView = itemView.findViewById(R.id.cardTicket)

    fun clickDetalle(): Observable<Any> {

        return RxView.clicks(cardTickets)

    }

    fun getId(): String {
        return txtNombre?.text.toString()
    }

    fun changeActivity() {
        print(getId())
        val intent = Intent(activity, HomeActivity::class.java)

        activity.startActivity(intent)
    }
}