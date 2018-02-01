package com.prueba.movies.adapters.popular.mvp

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.jakewharton.rxbinding2.view.RxView
import com.prueba.movies.R
import com.prueba.movies.activities.detail.DetailActivity
import com.prueba.movies.entities.Movie
import io.reactivex.Observable

class PopularViewHolder(itemView: View, val items: List<Movie>, val activity: Activity) : RecyclerView.ViewHolder(itemView) {
    val txtNombre: TextView? = itemView.findViewById(R.id.txtNombre)
    val txtTitulo: TextView? = itemView.findViewById(R.id.txtTitulo)
    val txtFechaEstreno: TextView? = itemView.findViewById(R.id.txtFechaEstreno)
    val cardTickets: CardView = itemView.findViewById(R.id.cardTicket)
    val imgPoster: ImageView = itemView.findViewById(R.id.imgPoster)
    val txtID: TextView? = itemView.findViewById(R.id.txtId)

    fun clickDetalle(): Observable<Any> {
        return RxView.clicks(cardTickets)

    }

    fun getId(): Int {
        return Integer.parseInt(txtID?.text.toString())
    }

    fun changeActivity() {
        print(getId())
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("ID", getId())
        activity.startActivity(intent)
    }
}