package co.com.smartquick.smarttickets.fragments.proyecto.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.FrameLayout
import co.com.smartquick.smarttickets.R
import co.com.smartquick.smarttickets.adapters.proyectos.ProyectoAdapter
import co.com.smartquick.smarttickets.entities.Proyecto
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_proyecto.view.*

@SuppressLint("ViewConstructor")
class FragmentProyectoView(val activity: Activity) : FrameLayout(activity) {
    init {
        View.inflate(context, R.layout.fragment_proyecto, this)
    }

    fun cargarDatosRecicler(lista: List<Proyecto>) {
        val linear = LinearLayoutManager(activity)
        rootView.reciclerProyecto.layoutManager = linear
        rootView.reciclerProyecto.adapter = ProyectoAdapter(activity, lista)
    }

    fun onEnterView(): Observable<Any> {
        return RxView.attaches(this)
    }
}