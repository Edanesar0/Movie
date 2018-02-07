package co.com.smartquick.smarttickets.activities.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import co.com.smartquick.smarttickets.activities.splash.dagger.DaggerSplashActivityComponent
import co.com.smartquick.smarttickets.activities.splash.dagger.SplashActivityModule
import co.com.smartquick.smarttickets.activities.splash.mvp.SplashPresenter
import co.com.smartquick.smarttickets.activities.splash.mvp.SplashView
import co.com.smartquick.smarttickets.app.SmartTicketsApplication
import javax.inject.Inject

@SuppressLint("Registered")
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var splashView: SplashView
    @Inject
    lateinit var splashPresenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSplashActivityComponent
                .builder()
                .appComponent(SmartTicketsApplication[this].component())
                .splashActivityModule(SplashActivityModule(this))
                .build().inject(this)
        setContentView(splashView)
        splashPresenter.onCreate()

    }

    override fun onDestroy() {
        super.onDestroy()
        splashPresenter.onDestroy()
    }
}
