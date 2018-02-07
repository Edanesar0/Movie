package co.com.smartquick.smarttickets.app.dagger.module

import android.content.Context

import co.com.smartquick.smarttickets.app.dagger.AppScope
import co.com.smartquick.smarttickets.app.dagger.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ContextModule(context: Context) {

    private val appContext: Context

    init {
        this.appContext = context.applicationContext
    }

    @Provides
    @AppScope
    @ApplicationContext
    fun context(): Context {
        return appContext
    }

}
