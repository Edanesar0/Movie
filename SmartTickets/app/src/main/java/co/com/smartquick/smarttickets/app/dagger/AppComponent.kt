package co.com.smartquick.smarttickets.app.dagger

import android.content.Context
import co.com.smartquick.smarttickets.app.dagger.module.AppModule
import co.com.smartquick.smarttickets.app.dagger.module.ContextModule
import co.com.smartquick.smarttickets.app.dagger.module.GsonModule
import co.com.smartquick.smarttickets.app.dagger.module.NetworkModule
import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import dagger.Component

@AppScope
@Component(modules = arrayOf(AppModule::class, ContextModule::class, NetworkModule::class, GsonModule::class))
interface AppComponent {
    fun context(): Context

    fun network(): SmartTicketsNetwork
}
