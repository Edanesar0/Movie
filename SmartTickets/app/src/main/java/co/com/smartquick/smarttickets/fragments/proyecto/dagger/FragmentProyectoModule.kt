package co.com.smartquick.smarttickets.fragments.proyecto.dagger

import android.app.Activity
import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import co.com.smartquick.smarttickets.fragments.proyecto.mvp.FragmentProyectoModel
import co.com.smartquick.smarttickets.fragments.proyecto.mvp.FragmentProyectoPresenter
import co.com.smartquick.smarttickets.fragments.proyecto.mvp.FragmentProyectoView
import dagger.Module
import dagger.Provides

@Module
class FragmentProyectoModule(private val activity: Activity) {


    @Provides
    @FragmentProyectoScope
    fun view(): FragmentProyectoView {
        return FragmentProyectoView(activity)
    }

    @Provides
    @FragmentProyectoScope
    fun model(network: SmartTicketsNetwork): FragmentProyectoModel {
        return FragmentProyectoModel(network)
    }

    @Provides
    @FragmentProyectoScope
    fun presenter(view: FragmentProyectoView, model: FragmentProyectoModel): FragmentProyectoPresenter {
        return FragmentProyectoPresenter(view, model)
    }

}
