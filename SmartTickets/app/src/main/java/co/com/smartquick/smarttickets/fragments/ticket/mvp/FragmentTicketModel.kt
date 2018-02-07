package co.com.smartquick.smarttickets.fragments.ticket.mvp

import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import co.com.smartquick.smarttickets.entities.Ticket
import io.realm.Realm
import io.realm.RealmResults

class FragmentTicketModel(private val network: SmartTicketsNetwork) {

    fun loadData(): List<Ticket> {
        val lista: ArrayList<Ticket> = ArrayList()
        val realm: Realm = Realm.getDefaultInstance()
        val tickets: RealmResults<Ticket> = realm.where(Ticket::class.java).findAll()
        lista += tickets
        return lista
    }
}