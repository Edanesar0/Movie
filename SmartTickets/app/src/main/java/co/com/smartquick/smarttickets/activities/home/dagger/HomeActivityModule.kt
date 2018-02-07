package co.com.smartquick.smarttickets.activities.home.dagger

import android.app.Activity
import co.com.smartquick.smarttickets.activities.home.mvp.HomeModel
import co.com.smartquick.smarttickets.activities.home.mvp.HomePresenter
import co.com.smartquick.smarttickets.activities.home.mvp.HomeView
import co.com.smartquick.smarttickets.app.network.SmartTicketsNetwork
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule(private val activity: Activity) {
    @Provides
    @HomeActivityScope
    fun view(): HomeView {
        return HomeView(activity)
    }

    @Provides
    @HomeActivityScope
    fun model(network: SmartTicketsNetwork): HomeModel {
        return HomeModel(network)
    }

    @Provides
    @HomeActivityScope
    fun presenter(view: HomeView, model: HomeModel): HomePresenter {
        return HomePresenter(view, model)
    }
}