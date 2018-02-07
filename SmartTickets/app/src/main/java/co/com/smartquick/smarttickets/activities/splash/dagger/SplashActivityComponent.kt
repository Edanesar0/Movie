package co.com.smartquick.smarttickets.activities.splash.dagger

import co.com.smartquick.smarttickets.activities.splash.SplashActivity
import co.com.smartquick.smarttickets.app.dagger.AppComponent
import dagger.Component

@SplashActivityScope
@Component(modules = arrayOf(SplashActivityModule::class), dependencies = [(AppComponent::class)])
interface SplashActivityComponent {
    fun inject(splashActivity: SplashActivity)

}
