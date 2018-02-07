package co.com.smartquick.smarttickets.app.network.model

import com.google.gson.annotations.SerializedName

data class Idquienpide(
        @field:SerializedName("apellido")
        val apellido: String? = null,

        @field:SerializedName("cargo")
        val cargo: Int? = null,

        @field:SerializedName("telefono")
        val telefono: String? = null,

        @field:SerializedName("nombre")
        val nombre: String? = null,

        @field:SerializedName("email")
        val email: String? = null,

        @field:SerializedName("idusuario")
        val idusuario: Int? = null,

        @field:SerializedName("persona")
        val idlider: Any? = null
)