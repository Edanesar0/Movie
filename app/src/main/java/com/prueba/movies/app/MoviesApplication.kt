package com.prueba.movies.app

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.app.Fragment
import android.app.Service
import com.prueba.movies.app.dagger.AppComponent
import com.prueba.movies.app.dagger.DaggerAppComponent
import com.prueba.movies.app.dagger.module.AppModule
import com.prueba.movies.app.dagger.module.ContextModule
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Clase de configuracion de la apliacion esta es la primera clase que se ejecuta y tiene toda la configuracion incial
 */
@SuppressLint("Registered")
class MoviesApplication : Application() {

    private var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        initRealmConfiguration()
        component = DaggerAppComponent.builder()
                .contextModule(ContextModule(this)) // must be injected by dagger look in future.
                .appModule(AppModule(this))
                .build()
    }

    /**
     * Metodo que nos permite la configuracion de la base de datos ORM que en este casi es realm.io
     */
    private fun initRealmConfiguration() {
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    fun component(): AppComponent? {
        return component
    }

    companion object {
        operator fun get(activity: Activity): MoviesApplication {
            return activity.application as MoviesApplication
        }

        operator fun get(fragment: Fragment): MoviesApplication {
            return fragment.activity.application as MoviesApplication
        }

        operator fun get(service: Service): MoviesApplication {
            return service.application as MoviesApplication
        }
    }
}
