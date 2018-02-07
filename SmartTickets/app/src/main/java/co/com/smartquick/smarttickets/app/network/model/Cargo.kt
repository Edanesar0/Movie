package co.com.smartquick.smarttickets.app.network.model

import com.google.gson.annotations.SerializedName

data class Cargo(

        @field:SerializedName("descripcion")
        val descripcion: String? = null,

        @field:SerializedName("idcargo")
        val idcargo: Int? = null
)