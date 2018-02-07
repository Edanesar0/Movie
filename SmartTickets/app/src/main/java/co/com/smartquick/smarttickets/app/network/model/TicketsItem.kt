package co.com.smartquick.smarttickets.app.network.model

import com.google.gson.annotations.SerializedName

data class TicketsItem(

        @field:SerializedName("idtickets")
        val idtickets: Int? = null,

        @field:SerializedName("descripcion")
        val descripcion: String? = null,

        @field:SerializedName("archivo")
        val archivo: Any? = null,

        @field:SerializedName("idproyecto")
        val idproyecto: List<IdproyectoItem?>? = null,

        @field:SerializedName("idquienpide")
        val idquienpide: Idquienpide? = null,

        @field:SerializedName("idtipo")
        val idtipo: Int? = null,

        @field:SerializedName("comentariodes")
        val comentariodes: Any? = null,

        @field:SerializedName("prioridad")
        val idprioridad: Idprioridad? = null,

        @field:SerializedName("estado")
        val idestado: Idestado? = null,

        @field:SerializedName("fechainicio")
        val fechainicio: String? = null,

        @field:SerializedName("horas")
        val horas: Any? = null,

        @field:SerializedName("fechaentrega")
        val fechaentrega: Any? = null,

        @field:SerializedName("porcentaje")
        val porcentaje: Int? = null,

        @field:SerializedName("idresponsable")
        val idresponsable: Idresponsable? = null
)