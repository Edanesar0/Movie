package co.com.smartquick.smarttickets.fragments.proyecto

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.com.smartquick.smarttickets.app.SmartTicketsApplication
import co.com.smartquick.smarttickets.fragments.proyecto.dagger.DaggerFragmentProyectoComponent
import co.com.smartquick.smarttickets.fragments.proyecto.dagger.FragmentProyectoModule
import co.com.smartquick.smarttickets.fragments.proyecto.mvp.FragmentProyectoPresenter
import co.com.smartquick.smarttickets.fragments.proyecto.mvp.FragmentProyectoView
import javax.inject.Inject

class FragmentProyecto : Fragment() {

    @Inject
    lateinit var proyectoView: FragmentProyectoView
    @Inject
    lateinit var proyectoPresenter: FragmentProyectoPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DaggerFragmentProyectoComponent
                .builder()
                .fragmentProyectoModule(FragmentProyectoModule(activity))
                .appComponent(SmartTicketsApplication[activity].component())
                .build().inject(this)
        proyectoPresenter.onCreate()
        return proyectoView
    }

    override fun onDestroy() {
        proyectoPresenter.onDestroy()
        super.onDestroy()
    }
}