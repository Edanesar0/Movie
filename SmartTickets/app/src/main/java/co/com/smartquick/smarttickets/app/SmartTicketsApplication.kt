package co.com.smartquick.smarttickets.app

import android.app.Activity
import android.app.Application
import android.app.Fragment
import android.app.Service
import co.com.smartquick.smarttickets.app.dagger.AppComponent
import co.com.smartquick.smarttickets.app.dagger.DaggerAppComponent
import co.com.smartquick.smarttickets.app.dagger.module.AppModule
import co.com.smartquick.smarttickets.app.dagger.module.ContextModule
import io.realm.Realm
import io.realm.RealmConfiguration


class SmartTicketsApplication : Application() {


    private var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        initRealmConfiguration()
        component = DaggerAppComponent.builder()
                .contextModule(ContextModule(this)) // must be injected by dagger look in future.
                .appModule(AppModule(this))
                .build()


    }

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
        operator fun get(activity: Activity): SmartTicketsApplication {
            return activity.application as SmartTicketsApplication
        }

        operator fun get(fragment: Fragment): SmartTicketsApplication {
            return fragment.activity.application as SmartTicketsApplication
        }

        operator fun get(service: Service): SmartTicketsApplication {
            return service.application as SmartTicketsApplication
        }
    }
}
