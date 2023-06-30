package com.example.doctorchanneling

data class Doctor(
    val image: Int,
    val name: String,
    val degree: String,
    val time: String,
    val noofMsg: Int
) {
    companion object {
        val listOfDoctor = arrayListOf<Doctor>(
            Doctor(R.drawable.avatar_1, "Dr.Upul", "Worem consectetur adipiscing elit.","12.50", 2),
            Doctor(R.drawable.avatar_2, "Dr.Silva", "Worem consectetur adipiscing elit.","12.50", 0),
            Doctor(R.drawable.avatar_3, "Dr.Pawani", "Worem consectetur adipiscing elit.","12.50", 0),
            Doctor(R.drawable.avatar_4, "Dr.Rayan", "Worem consectetur adipiscing elit.","12.50", 0),
        )
    }
}

data class Profile(
    val image: Int,
) {
    companion object {
        val listOfProfile = arrayListOf<Profile>(
            Profile(R.drawable.profile_1),
            Profile(R.drawable.profile_2),
            Profile(R.drawable.profile_3),
            Profile(R.drawable.profile_4),
            Profile(R.drawable.profile_5),
            Profile(R.drawable.profile_1)
        )
    }
}

