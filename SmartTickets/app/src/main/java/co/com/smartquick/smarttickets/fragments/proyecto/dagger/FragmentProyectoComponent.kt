package co.com.smartquick.smarttickets.fragments.proyecto.dagger

import co.com.smartquick.smarttickets.app.dagger.AppComponent
import co.com.smartquick.smarttickets.fragments.proyecto.FragmentProyecto
import dagger.Component

@FragmentProyectoScope
@Component(modules = arrayOf(FragmentProyectoModule::class), dependencies = arrayOf(AppComponent::class))
interface FragmentProyectoComponent {
    fun inject(fragmentProyecto: FragmentProyecto)
}