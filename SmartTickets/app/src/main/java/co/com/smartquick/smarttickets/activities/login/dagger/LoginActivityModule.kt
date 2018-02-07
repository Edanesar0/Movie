package co.com.smartquick.smarttickets.activities.login.dagger

import android.app.Activity
import co.com.smartquick.smarttickets.activities.login.mvp.LoginModel
import co.com.smartquick.smarttickets.activities.login.mvp.LoginPresenter
import co.com.smartquick.smarttickets.activities.login.mvp.LoginView
import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule(private val activity: Activity) {


    @Provides
    @LoginActivityScope
    fun view(): LoginView {
        return LoginView(activity)
    }

    @Provides
    @LoginActivityScope
    fun model(network: SmartTicketsNetwork): LoginModel {
        return LoginModel(network)
    }

    @Provides
    @LoginActivityScope
    fun presenter(view: LoginView, model: LoginModel): LoginPresenter {
        return LoginPresenter(view, model)
    }

}
