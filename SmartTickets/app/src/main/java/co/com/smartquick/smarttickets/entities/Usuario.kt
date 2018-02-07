package co.com.smartquick.smarttickets.entities

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey

open class Usuario(
        @PrimaryKey
        var idusuario: Int = 0,
        var nombre: String? = null,
        var apellido: String? = null,
        var cargo: Cargo? = null,
        var email: String? = null,
        var telefono: String? = null,
        var activo: Boolean? = null,
        var idlider: Usuario? = null,
        var proyectos: RealmList<Proyecto?>? = null,
        var tickets: RealmList<Ticket?>? = null,
        @Ignore
        var pass: String? = null)
    : RealmObject()
