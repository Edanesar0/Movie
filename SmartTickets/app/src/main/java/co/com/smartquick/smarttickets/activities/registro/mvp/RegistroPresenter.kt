package co.com.smartquick.smarttickets.activities.registro.mvp

import android.util.Log
import android.widget.Toast
import co.com.smartquick.smarttickets.entities.Usuario
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

/**
 * Constructor used for dagger2 and then injected
 * .
 *
 * @param view  The view which init all the layout variables.
 * @param model Saves and load data form remote or local database.
 */
class RegistroPresenter(private val view: RegistroView, private val model: RegistroModel) {
    private val disposable = CompositeDisposable()

    fun onCreate() {
        disposable.add(buttonClickLogin())
    }

    fun onDestroy() {
        disposable.clear()
    }

    private fun buttonClickLogin(): Disposable {
        return view.buttonRegister()
                .subscribe {
                    val usuario = view.validateRegister()
                    if (usuario != null) {
                        disposable.add(senRegister(usuario))
                    }
                }
    }

    private fun senRegister(usuario: Usuario?): Disposable {
        val json: JSONObject
        json = JSONObject()
        json.put("nombre", usuario?.nombre)
        json.put("apellido", usuario?.apellido)
        json.put("password", usuario?.pass)
        json.put("email", usuario?.email)
        json.put("telefono", usuario?.telefono)
        return model.registroObservable(json.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view.showDialog() }
                .doOnTerminate { view.dismissDialog() }
                .subscribe({ response ->
                    Toast.makeText(view.context, "Usuario Registrado", Toast.LENGTH_LONG).show()
                    disposable.add(saveUsuario(response))
                }, { throwable ->
                    Toast.makeText(view.context, "" + throwable, Toast.LENGTH_LONG).show()
                    Log.e("observer", throwable.toString())
                }
                )

    }

    private fun saveUsuario(usuario: String): Disposable {
        return model.saveUsuarioRealm(usuario)
                ?.subscribe({ usuarios ->
                    if (usuarios != null) {
                        view.changeActivity()
                    } else {
                        Toast.makeText(view.context, "No se pudo guardar el usuario ", Toast.LENGTH_LONG).show()
                    }
                }, { throwable ->
                    Toast.makeText(view.context, "" + throwable, Toast.LENGTH_LONG).show()
                    Log.e("observer", throwable.toString())
                }
                )!!

    }

}
