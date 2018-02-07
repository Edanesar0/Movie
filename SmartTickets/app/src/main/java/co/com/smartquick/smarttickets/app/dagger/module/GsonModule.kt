package co.com.smartquick.smarttickets.app.dagger.module

import co.com.smartquick.smarttickets.app.dagger.AppScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides

@Module
class GsonModule {

    @AppScope
    @Provides
    fun gson(): Gson {
        return GsonBuilder()
                .serializeNulls()
                .create()
    }
}
