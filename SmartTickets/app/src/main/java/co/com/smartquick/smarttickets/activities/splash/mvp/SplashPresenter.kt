package co.com.smartquick.smarttickets.activities.splash.mvp

import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SplashPresenter(private val view: SplashView, private val model: SplashModel) {
    private val disposable = CompositeDisposable()

    fun onCreate() {
        disposable.add(loadData())
    }

    fun onDestroy() {
        disposable.clear()
    }

    fun loadData(): Disposable {
        return view.onEnterView()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    disposable.add(getProyectos())
                })
    }

    private fun getProyectos(): Disposable {
        return model.getProyectos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    disposable.add(saveProyecto(it))
                }, { throwable ->
                    Log.e("observer", throwable.toString())
                }
                )
    }

    private fun getUsuario(): Disposable {
        return model.loadUsuarios()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    disposable.add(saveUsuario(it))
                }, { throwable ->
                    Log.e("observer", throwable.toString())
                }
                )
    }

    private fun getCargo(): Disposable {
        return model.loadCargos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    disposable.add(saveCargo(it))
                }, { throwable ->
                    Log.e("observer", throwable.toString())
                }
                )
    }

    private fun saveProyecto(top: String): Disposable {
        return model.saveProyectosRealm(top)?.subscribe({
            disposable.add(getUsuario())
        }, { throwable ->
            Toast.makeText(view.context, "" + throwable, Toast.LENGTH_LONG).show()
            Log.e("observer", throwable.toString())
        }
        )!!
    }

    private fun saveUsuario(usuario: String): Disposable {
        return model.saveUsuarioRealm(usuario)?.subscribe({
            disposable.add(getCargo())
        }, { throwable ->
            Toast.makeText(view.context, "" + throwable, Toast.LENGTH_LONG).show()
            Log.e("observer", throwable.toString())
        }
        )!!
    }

    private fun saveCargo(cargo: String): Disposable {
        return model.saveCargosRealm(cargo)?.subscribe({
            if (it != null) {
                view.changeActivity()
            } else {
                Toast.makeText(view.context, "No se pudo guardar los cargo ", Toast.LENGTH_LONG).show()
            }
        }, { throwable ->
            Toast.makeText(view.context, "" + throwable, Toast.LENGTH_LONG).show()
            Log.e("observer", throwable.toString())
        }
        )!!
    }
}
