package com.example.firstandroidui

data class ProfileImage(val image: Int) {
    companion object {
        val listofImages: MutableList<ProfileImage> = mutableListOf(
            ProfileImage(R.drawable.img_available),
            ProfileImage(R.drawable.img_status_msg),
            ProfileImage(R.drawable.img_meeting_id),
            ProfileImage(R.drawable.img_personal_info),
            ProfileImage(R.drawable.img_help)
        )
    }
}