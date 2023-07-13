package com.example.doctorchanneling.profile

import com.example.doctorchanneling.R

data class ProfileImages(val images: Int) {
    companion object {
        val listofImages: MutableList<ProfileImages> = mutableListOf(
            ProfileImages(R.drawable.history),
            ProfileImages(R.drawable.personal_details),
            ProfileImages(R.drawable.location),
            ProfileImages(R.drawable.payment_method),
            ProfileImages(R.drawable.setting),
            ProfileImages(R.drawable.help),
            ProfileImages(R.drawable.logout)
        )
    }
}