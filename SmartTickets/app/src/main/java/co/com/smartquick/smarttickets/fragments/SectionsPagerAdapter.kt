package co.com.smartquick.smarttickets.fragments


import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import co.com.smartquick.smarttickets.fragments.proyecto.FragmentProyecto
import co.com.smartquick.smarttickets.fragments.ticket.FragmentTicket


class SectionsPagerAdapter(fm: FragmentManager, val activity: Activity) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null

        when (position) {
            0 -> {
                fragment = Fragment.instantiate(activity, FragmentTicket::class.java.name)
                val args = Bundle()
                fragment.arguments = args
            }
            1 -> {
                fragment = Fragment.instantiate(activity, FragmentProyecto::class.java.name)
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