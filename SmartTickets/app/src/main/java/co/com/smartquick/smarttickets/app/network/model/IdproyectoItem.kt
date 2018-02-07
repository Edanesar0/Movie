package co.com.smartquick.smarttickets.app.network.model

import com.google.gson.annotations.SerializedName

data class IdproyectoItem(
        @field:SerializedName("color")
        val color: String? = null,

        @field:SerializedName("idproyecto")
        val idproyecto: Int? = null,

        @field:SerializedName("logo")
        val logo: Any? = null,

        @field:SerializedName("nombre")
        val nombre: String? = null,

        @field:SerializedName("estado")
        val idestado: Idestado? = null
)