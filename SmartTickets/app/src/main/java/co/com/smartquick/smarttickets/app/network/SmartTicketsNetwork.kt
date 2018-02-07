package co.com.smartquick.smarttickets.app.network

import co.com.smartquick.smarttickets.app.network.model.LoginRequest
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface SmartTicketsNetwork {

    @POST("inicio_sesion.php")
    fun getLogin(@Body loginRequest: LoginRequest): Observable<String>

    @POST("registrar_usuario.php")
    fun sendRegister(@Body string: String): Observable<String>

    @POST("proyecto.php")
    fun getProyectos(): Observable<String>

    @POST("usuario.php")
    fun getUsuarios(): Observable<String>

    @POST("cargos.php")
    fun getCargos(): Observable<String>
}












