package co.com.smartquick.smarttickets.activities.home.mvp

import android.app.Activity
import android.support.design.widget.TabLayout
import android.view.View
import android.widget.FrameLayout
import co.com.smartquick.smarttickets.R
import co.com.smartquick.smarttickets.activities.home.HomeActivity
import co.com.smartquick.smarttickets.fragments.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.view.*


class HomeView(activity: Activity) : FrameLayout(activity) {
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    init {
        View.inflate(context, R.layout.activity_main, this)
        val supportFragmentManager = (activity as HomeActivity).supportFragmentManager
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, activity)
        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }
}
