package com.prueba.movies.fragments


import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.prueba.movies.fragments.popular.FragmentPopular
import com.prueba.movies.fragments.top.FragmentTop


class SectionsPagerAdapter(fm: FragmentManager, val activity: Activity) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null

        when (position) {
            0 -> {
                fragment = Fragment.instantiate(activity, FragmentPopular::class.java.name)
                val args = Bundle()
                fragment.arguments = args
            }
            1 -> {
                fragment = Fragment.instantiate(activity, FragmentTop::class.java.name)
                val args = Bundle()
                fragment.arguments = args
            }
        }
        return fragment
    }

    override fun getCount(): Int {
        return 2
    }
}