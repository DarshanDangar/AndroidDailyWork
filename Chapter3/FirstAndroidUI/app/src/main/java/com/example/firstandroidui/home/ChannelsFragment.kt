package com.example.firstandroidui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstandroidui.R
import com.example.firstandroidui.databinding.FragmentChannelsBinding

class ChannelsFragment : Fragment(), ActivityMenuProvider {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentChannelsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getMenu(): Int = R.menu.item_chat

}