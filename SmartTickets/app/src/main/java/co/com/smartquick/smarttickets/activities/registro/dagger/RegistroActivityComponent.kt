package co.com.smartquick.smarttickets.activities.registro.dagger

import co.com.smartquick.smarttickets.activities.registro.RegistroActivity
import co.com.smartquick.smarttickets.app.dagger.AppComponent
import dagger.Component

@RegistroActivityScope
@Component(modules = arrayOf(RegistroActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface RegistroActivityComponent {
    fun injectRegistroActivity(registroActivity: RegistroActivity)

}
