package co.com.smartquick.smarttickets.activities.splash.mvp

import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import co.com.smartquick.smarttickets.entities.Cargo
import co.com.smartquick.smarttickets.entities.Proyecto
import co.com.smartquick.smarttickets.entities.Usuario
import io.reactivex.Observable
import io.realm.Realm


class SplashModel(private val network: SmartTicketsNetwork) {

    fun getProyectos(): Observable<String> {
        return network.getProyectos()
    }

    fun loadUsuarios(): Observable<String> {
        return network.getUsuarios()
    }

    fun loadCargos(): Observable<String> {
        return network.getCargos()
    }

    fun saveProyectosRealm(proyecto: String): Observable<Any?>? {
        return Observable.fromCallable {
            try {
                val realm = Realm.getDefaultInstance()
                var top1: Proyecto? = null
                realm.executeTransaction({
                    realm.createOrUpdateAllFromJson(Proyecto::class.java, proyecto)
                })
                return@fromCallable top1
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun saveUsuarioRealm(usuario: String): Observable<Any?>? {
        return Observable.fromCallable {
            try {
                val realm = Realm.getDefaultInstance()
                var pop: Usuario? = null
                realm.executeTransaction({
                    realm.createOrUpdateAllFromJson(Usuario::class.java, usuario)
                })
                return@fromCallable pop
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun saveCargosRealm(cargos: String): Observable<Any?>? {
        return Observable.fromCallable {
            try {
                val realm = Realm.getDefaultInstance()
                realm.executeTransaction({
                    realm.createOrUpdateAllFromJson(Cargo::class.java, cargos)
                })
                return@fromCallable " "
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}