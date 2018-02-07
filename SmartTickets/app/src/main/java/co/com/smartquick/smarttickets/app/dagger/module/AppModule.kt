package co.com.smartquick.smarttickets.app.dagger.module

import android.app.Application
import android.content.Context

import co.com.smartquick.smarttickets.app.SmartTicketsApplication
import co.com.smartquick.smarttickets.app.dagger.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: SmartTicketsApplication) {
    private val context: Context

    init {
        this.context = application.applicationContext
    }

    @Provides
    @AppScope
    fun application(): Application {
        return application
    }

    @AppScope
    @Provides
    fun context(): Context {
        return context
    }

}
