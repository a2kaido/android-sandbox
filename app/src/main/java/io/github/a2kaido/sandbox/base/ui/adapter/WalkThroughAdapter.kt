package io.github.a2kaido.sandbox.base.ui.adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import io.github.a2kaido.sandbox.R
import io.github.a2kaido.sandbox.base.ui.WalkThroughChildFragment

class WalkThroughAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = when (position) {
        0 -> WalkThroughChildFragment.newInstance(R.drawable.ic_launcher_foreground)
        1 -> WalkThroughChildFragment.newInstance(R.drawable.ic_launcher_foreground)
        2 -> WalkThroughChildFragment.newInstance(R.drawable.ic_launcher_foreground)
        else -> throw IllegalAccessError("invalid position")
    }

    override fun getCount() = 3
}