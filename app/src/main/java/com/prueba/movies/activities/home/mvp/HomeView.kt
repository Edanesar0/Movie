package com.prueba.movies.activities.home.mvp

import android.annotation.SuppressLint
import android.app.Activity
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.support.design.widget.TabLayout
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import android.widget.FrameLayout
import com.jakewharton.rxbinding2.InitialValueObservable
import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView
import com.jakewharton.rxbinding2.support.v7.widget.SearchViewQueryTextEvent
import com.prueba.movies.R
import com.prueba.movies.activities.home.HomeActivity
import com.prueba.movies.activities.search.SearchActivity
import com.prueba.movies.fragments.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.view.*


@SuppressLint("ViewConstructor")
class HomeView(var activity: Activity) : FrameLayout(activity) {
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    var menu: Menu? = null

    init {
        View.inflate(context, R.layout.activity_main, this)
        val supportFragmentManager = (activity as HomeActivity).supportFragmentManager
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, activity)
        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

    /**
     * Handle change in searchView text char to char
     *
     * @return [InitialValueObservable] on char added or removed.
     */
    fun searchViewChange(): InitialValueObservable<SearchViewQueryTextEvent> {
        val manager = activity.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val search = menu?.findItem(R.id.action_find)?.actionView as SearchView
        search.setSearchableInfo(manager.getSearchableInfo(activity.componentName))
        return RxSearchView.queryTextChangeEvents(search)

    }


    fun changeActivity() {
        context.startActivity(Intent(context, SearchActivity::class.java))

    }
}
