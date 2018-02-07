package co.com.smartquick.smarttickets.app.network.model

import com.google.gson.annotations.SerializedName


data class Login(
        @field:SerializedName("tickets")
        val tickets: List<TicketsItem?>? = null,

        @field:SerializedName("apellido")
        val apellido: String? = null,

        @field:SerializedName("cargo")
        val cargo: Cargo? = null,

        @field:SerializedName("telefono")
        val telefono: String? = null,

        @field:SerializedName("proyectos")
        val proyectos: List<ProyectosItem?>? = null,

        @field:SerializedName("nombre")
        val nombre: String? = null,

        @field:SerializedName("email")
        val email: String? = null,

        @field:SerializedName("idusuario")
        val idusuario: Int? = null,

        @field:SerializedName("activo")
        val activo: Boolean? = null,

        @field:SerializedName("persona")
        val idlider: Idlider? = null
)