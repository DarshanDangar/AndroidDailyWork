package com.example.firstandroidui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.firstandroidui.R
import com.example.firstandroidui.databinding.FragmentProfileBinding
import com.example.firstandroidui.home.ActivityMenuProvider

class ProfileFragment : Fragment(), ActivityMenuProvider {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        return binding.root
    }

    override fun getMenu(): Int = R.menu.item_profile

}