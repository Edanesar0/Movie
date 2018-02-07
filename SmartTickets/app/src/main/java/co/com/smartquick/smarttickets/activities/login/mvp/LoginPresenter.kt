package co.com.smartquick.smarttickets.activities.login.mvp

import android.content.Intent
import android.util.Log
import android.widget.Toast
import co.com.smartquick.smarttickets.activities.registro.RegistroActivity
import co.com.smartquick.smarttickets.app.network.model.LoginRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Constructor used for dagger2 and then injected
 * .
 *
 * @param view  The view which init all the layout variables.
 * @param model Saves and load data form remote or local database.
 */
class LoginPresenter(private val view: LoginView, private val model: LoginModel) {
    private val disposable = CompositeDisposable()

    fun onCreate() {
        disposable.add(buttonClickLogin())
        disposable.add(buttonClickCrearCuenta())
    }

    fun onDestroy() {
        disposable.clear()
    }

    private fun buttonClickLogin(): Disposable {
        return view.buttonCLickLogin()
                .subscribe {
                    val loginRequest = view.attemptLogin()
                    if (loginRequest != null) {
                        disposable.add(getLogin(loginRequest))
                    }
                }
    }

    private fun buttonClickCrearCuenta(): Disposable {
        return view.buttonCLickCrearCuenta()
                .subscribe {
                    view.context.startActivity(Intent(view.context, RegistroActivity::class.java))
                }
    }

    private fun getLogin(loginRequest: LoginRequest): Disposable {
        return model.usuarioObservable(loginRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                /*.doOnSubscribe { view.showDialog() }
                .doOnTerminate { view.dismissDialog() }*/
                .subscribe({ usuario ->
                    disposable.add(saveUsuario(usuario))
                }, { throwable ->
                    Log.e("observer", throwable.toString())
                }
                )
    }


    private fun saveUsuario(usuario: String): Disposable {
        return model.saveUsuarioRealm(usuario)?.subscribe({ usuarios ->
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
