package co.com.smartquick.smarttickets.fragments.proyecto.mvp

import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import co.com.smartquick.smarttickets.entities.Proyecto
import io.realm.Realm
import io.realm.RealmResults

class FragmentProyectoModel(private val network: SmartTicketsNetwork) {

    fun loadData(): List<Proyecto> {
        val lista: ArrayList<Proyecto> = ArrayList()
        val realm: Realm = Realm.getDefaultInstance()
        val tickets: RealmResults<Proyecto> = realm.where(Proyecto::class.java).findAll()
        lista += tickets
        return lista
    }
}