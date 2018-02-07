package co.com.smartquick.smarttickets.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Tipo : RealmObject() {
    @PrimaryKey
    var idtipoticket: Int = 0
    var descripcion: String = ""
}