package co.com.smartquick.smarttickets.activities.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import co.com.smartquick.smarttickets.activities.login.dagger.DaggerLoginActivityComponent
import co.com.smartquick.smarttickets.activities.login.dagger.LoginActivityModule

import co.com.smartquick.smarttickets.activities.login.mvp.LoginPresenter
import co.com.smartquick.smarttickets.activities.login.mvp.LoginView
import co.com.smartquick.smarttickets.app.SmartTicketsApplication
import javax.inject.Inject

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    @Inject
    lateinit var loginView: LoginView
    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerLoginActivityComponent
                .builder()
                .appComponent(SmartTicketsApplication.get(this).component())
                .loginActivityModule(LoginActivityModule(this))
                .build().injectLoginActivity(this)
        setContentView(loginView)
        loginPresenter.onCreate()

    }

    override fun onDestroy() {
        loginPresenter.onDestroy()
        super.onDestroy()
    }
}
