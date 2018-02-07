package co.com.smartquick.smarttickets.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Estado : RealmObject() {
    @PrimaryKey
    var idestado: Int = 0
    var descripcion: String = ""
}
