package com.example.firstandroidui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.firstandroidui.R
import com.example.firstandroidui.databinding.FragmentChatBinding
import com.example.firstandroidui.home.ActivityMenuProvider
import com.example.firstandroidui.home.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class ChatFragment : Fragment(), ActivityMenuProvider {

    private lateinit var binding: FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false)
        binding.viewPager.adapter = ViewPagerAdapter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tabChat.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewPager.setCurrentItem(tab.position, true)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabChat.getTabAt(position)?.select()
            }
        })
    }

    override fun getMenu(): Int = R.menu.item_chat

}