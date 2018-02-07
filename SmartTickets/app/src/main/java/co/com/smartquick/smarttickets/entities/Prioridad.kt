package co.com.smartquick.smarttickets.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Prioridad : RealmObject() {
    var decripcion: String = ""
    @PrimaryKey
    var idprioridad: Int = 0
}
