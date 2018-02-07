package co.com.smartquick.smarttickets.activities.registro


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import co.com.smartquick.smarttickets.activities.registro.dagger.DaggerRegistroActivityComponent
import co.com.smartquick.smarttickets.activities.registro.dagger.RegistroActivityModule
import co.com.smartquick.smarttickets.activities.registro.mvp.RegistroPresenter
import co.com.smartquick.smarttickets.activities.registro.mvp.RegistroView
import co.com.smartquick.smarttickets.app.SmartTicketsApplication
import kotlinx.android.synthetic.main.activity_registro.*
import javax.inject.Inject

class RegistroActivity : AppCompatActivity() {
    @Inject
    lateinit var registroView: RegistroView
    @Inject
    lateinit var registroPresenter: RegistroPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerRegistroActivityComponent
                .builder()
                .registroActivityModule(RegistroActivityModule(this))
                .appComponent(SmartTicketsApplication.get(this).component())
                .build().injectRegistroActivity(this)

        setContentView(registroView)
        registroPresenter.onCreate()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

    }

    override fun onDestroy() {
        registroPresenter.onDestroy()
        super.onDestroy()
    }
}

