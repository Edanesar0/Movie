package co.com.smartquick.smarttickets.entities

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Ticket : RealmObject() {
    @PrimaryKey
    var idtickets: Int = 0
    var idresponsable: Usuario? = null
    var idquienpide: Usuario? = null
    var fechainicio: String? = null
    var fechaentrega: String? = null
    var horas: String? = null
    var porcentaje: Int = 0
    var idestado: Estado? = null
    var descripcion: String? = null
    var idtipo: Tipo? = null
    var idprioridad: Prioridad? = null
    var archivo: String? = null
    var idproyecto: RealmList<Proyecto?>? = null
    var comentariodes: String? = null
}
