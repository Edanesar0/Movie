package co.com.smartquick.smarttickets.activities.login.dagger

import co.com.smartquick.smarttickets.activities.login.LoginActivity
import co.com.smartquick.smarttickets.app.dagger.AppComponent
import dagger.Component

@LoginActivityScope
@Component(modules = arrayOf(LoginActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface LoginActivityComponent {
    fun injectLoginActivity(loginActivity: LoginActivity)

}
