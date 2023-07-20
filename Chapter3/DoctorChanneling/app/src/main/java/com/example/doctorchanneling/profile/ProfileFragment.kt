package com.example.doctorchanneling.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.doctorchanneling.R
import com.example.doctorchanneling.helper.SharedPreferenceHelper
import com.example.doctorchanneling.authentication.SignInActivity
import com.example.doctorchanneling.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        logout()
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val images = ProfileImages.listofImages
        binding.history.image = images[0]
        binding.personalDetails.image = images[1]
        binding.location.image = images[2]
        binding.paymentMethod.image = images[3]
        binding.setting.image = images[4]
        binding.help.image = images[5]
        binding.logOut.image = images[6]
    }

    private fun logout() {
        binding.logOut.root.setOnClickListener {
            SharedPreferenceHelper.putBoolean("signin", false)
            val intent = Intent(requireActivity(), SignInActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

}