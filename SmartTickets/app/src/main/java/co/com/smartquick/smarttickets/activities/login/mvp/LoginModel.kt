package co.com.smartquick.smarttickets.activities.login.mvp

import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import co.com.smartquick.smarttickets.app.network.model.LoginRequest
import co.com.smartquick.smarttickets.entities.Usuario
import io.reactivex.Observable
import io.realm.Realm

class LoginModel(private val network: SmartTicketsNetwork) {

    fun usuarioObservable(loginRequest: LoginRequest): Observable<String> {
        return network.getLogin(loginRequest)
    }

    fun saveUsuarioRealm(usuario: String): Observable<Any?>? {
        return Observable.fromCallable {
            try {
                val realm = Realm.getDefaultInstance()
                var us: Usuario? = null
                realm.executeTransaction({
                    us = realm.createOrUpdateObjectFromJson(Usuario::class.java, usuario)
                })
                return@fromCallable us
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
