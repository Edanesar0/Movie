package co.com.smartquick.smarttickets.app.network.model

import com.google.gson.annotations.SerializedName

data class Idestado(
        @field:SerializedName("descripcion")
        val descripcion: String? = null,

        @field:SerializedName("estado")
        val idestado: Int? = null
)