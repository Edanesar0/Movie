package co.com.smartquick.smarttickets.app.network.model

import com.google.gson.annotations.SerializedName


data class Idprioridad(
        @field:SerializedName("decripcion")
        val decripcion: String? = null,

        @field:SerializedName("prioridad")
        val idprioridad: Int? = null
)