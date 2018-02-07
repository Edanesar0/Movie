package co.com.smartquick.smarttickets.adapters.ticket.mvp

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import co.com.smartquick.smarttickets.R
import co.com.smartquick.smarttickets.entities.Ticket

class TicketViewHolder(itemView: View?, items: List<Ticket>, activity: Activity) : RecyclerView.ViewHolder(itemView) {
    val txtProyecto: TextView? = itemView?.findViewById(R.id.txtProyecto)
    val txtAsignado: TextView? = itemView?.findViewById(R.id.txtAsignado)
    val txtNombre: TextView? = itemView?.findViewById(R.id.txtNombre)
    val txtFecha: TextView? = itemView?.findViewById(R.id.txtFecha)
    val txtEstado: TextView? = itemView?.findViewById(R.id.txtEstado)
}