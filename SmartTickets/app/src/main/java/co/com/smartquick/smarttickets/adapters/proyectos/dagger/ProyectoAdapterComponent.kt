package co.com.smartquick.smarttickets.adapters.proyectos.dagger

import co.com.smartquick.smarttickets.adapters.proyectos.ProyectoAdapter
import co.com.smartquick.smarttickets.app.dagger.AppComponent
import dagger.Component

@ProyectoAdapterScope
@Component(modules = arrayOf(ProyectoAdapterModule::class), dependencies = [(AppComponent::class)])
interface ProyectoAdapterComponent {
    fun inject(proyectoAdapter: ProyectoAdapter)
}