package co.com.smartquick.smarttickets.activities.splash.dagger

import android.app.Activity
import co.com.smartquick.smarttickets.activities.splash.mvp.SplashModel
import co.com.smartquick.smarttickets.activities.splash.mvp.SplashPresenter
import co.com.smartquick.smarttickets.activities.splash.mvp.SplashView
import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule(private val activity: Activity) {
    @Provides
    @SplashActivityScope
    fun view(): SplashView {
        return SplashView(activity)
    }

    @Provides
    @SplashActivityScope
    fun model(network: SmartTicketsNetwork): SplashModel {
        return SplashModel(network)
    }

    @Provides
    @SplashActivityScope
    fun presenter(view: SplashView, model: SplashModel): SplashPresenter {
        return SplashPresenter(view, model)
    }
}