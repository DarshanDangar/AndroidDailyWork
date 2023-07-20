package com.example.firstandroidui.home.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.firstandroidui.ProfileImage
import com.example.firstandroidui.R
import com.example.firstandroidui.SignInActivity
import com.example.firstandroidui.databinding.FragmentProfileBinding
import com.example.firstandroidui.helper.SharedPreferenceHelper
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val images = ProfileImage.listofImages
        binding.item1.image = images[0]
        binding.item2.image = images[1]
        binding.item3.image = images[2]
        binding.item4.image = images[3]
        binding.item5.image = images[4]

        binding.btnLogout.setOnClickListener {
            SharedPreferenceHelper.putBoolean("login", false)
            val intent = Intent(requireActivity(), SignInActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

    override fun getMenu(): Int = R.menu.item_profile

}