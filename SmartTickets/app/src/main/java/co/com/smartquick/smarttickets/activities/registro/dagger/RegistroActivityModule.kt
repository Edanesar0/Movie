package co.com.smartquick.smarttickets.activities.registro.dagger

import android.app.Activity
import co.com.smartquick.smarttickets.activities.registro.mvp.RegistroModel
import co.com.smartquick.smarttickets.activities.registro.mvp.RegistroPresenter
import co.com.smartquick.smarttickets.activities.registro.mvp.RegistroView
import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import dagger.Module
import dagger.Provides

@Module
class RegistroActivityModule(private val activity: Activity) {


    @Provides
    @RegistroActivityScope
    fun view(): RegistroView {
        return RegistroView(activity)
    }

    @Provides
    @RegistroActivityScope
    fun model(network: SmartTicketsNetwork): RegistroModel {
        return RegistroModel(network)
    }

    @Provides
    @RegistroActivityScope
    fun presenter(view: RegistroView, model: RegistroModel): RegistroPresenter {
        return RegistroPresenter(view, model)
    }

}
