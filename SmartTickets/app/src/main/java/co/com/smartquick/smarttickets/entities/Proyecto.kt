package co.com.smartquick.smarttickets.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Proyecto : RealmObject() {
    @PrimaryKey
    var idproyecto: Int = 0
    var color: String = ""
    var logo: String? = null
    var nombre: String = ""
    var idestado: Estado? = null
}
