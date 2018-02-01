package com.prueba.movies.activities.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.prueba.movies.activities.splash.dagger.DaggerSplashActivityComponent
import com.prueba.movies.activities.splash.dagger.SplashActivityModule
import com.prueba.movies.activities.splash.mvp.SplashPresenter
import com.prueba.movies.activities.splash.mvp.SplashView
import com.prueba.movies.app.MoviesApplication
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var splashView: SplashView
    @Inject
    lateinit var splashPresenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSplashActivityComponent
                .builder()
                .appComponent(MoviesApplication[this].component())
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
