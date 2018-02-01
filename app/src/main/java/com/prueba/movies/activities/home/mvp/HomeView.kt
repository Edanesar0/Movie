package com.prueba.movies.activities.home.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.support.design.widget.TabLayout
import android.view.View
import android.widget.FrameLayout
import com.prueba.movies.R
import com.prueba.movies.activities.home.HomeActivity
import com.prueba.movies.fragments.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.view.*


@SuppressLint("ViewConstructor")
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
