package co.com.smartquick.smarttickets.activities.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import co.com.smartquick.smarttickets.R
import co.com.smartquick.smarttickets.activities.home.dagger.DaggerHomeActivityComponent
import co.com.smartquick.smarttickets.activities.home.dagger.HomeActivityModule
import co.com.smartquick.smarttickets.activities.home.mvp.HomePresenter
import co.com.smartquick.smarttickets.activities.home.mvp.HomeView
import co.com.smartquick.smarttickets.app.SmartTicketsApplication
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */

    @Inject
    lateinit var homeView: HomeView
    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerHomeActivityComponent
                .builder()
                .appComponent(SmartTicketsApplication.get(this).component())
                .homeActivityModule(HomeActivityModule(this))
                .build().injectHomeActivity(this)
        setContentView(homeView)

        setSupportActionBar(toolbar)
        homePresenter.onCreate()

    }

    override fun onDestroy() {
        homePresenter.onDestroy()
        super.onDestroy()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}
