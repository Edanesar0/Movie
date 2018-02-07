package co.com.smartquick.smarttickets.activities.home.dagger

import co.com.smartquick.smarttickets.activities.home.HomeActivity
import co.com.smartquick.smarttickets.app.dagger.AppComponent
import dagger.Component

@HomeActivityScope
@Component(modules = arrayOf(HomeActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface HomeActivityComponent {
    fun injectHomeActivity(homeActivity: HomeActivity)

}
