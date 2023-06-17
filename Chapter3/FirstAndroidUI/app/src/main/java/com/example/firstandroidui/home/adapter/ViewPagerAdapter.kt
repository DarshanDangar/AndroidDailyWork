package com.example.firstandroidui.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstandroidui.home.fragment.ChannelsFragment
import com.example.firstandroidui.home.fragment.DirectMessageFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private var fragmentList = listOf(DirectMessageFragment(), ChannelsFragment())

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}

