package co.com.smartquick.smarttickets.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Cargo : RealmObject() {
    @PrimaryKey
    var idcargo: Int = 0
    var descripcion: String = ""
}
