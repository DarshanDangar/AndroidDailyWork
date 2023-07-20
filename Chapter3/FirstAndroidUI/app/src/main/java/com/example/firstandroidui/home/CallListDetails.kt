package com.example.firstandroidui.home

import com.example.firstandroidui.R

data class CallListDetails(
    val name: String,
    val timeDuration: String,
    val dateAndTime: String,
    val imagePerson: Int
)

class DataCallList {
    companion object {
        val listofCall: List<CallListDetails> = listOf(
            CallListDetails("Savannah Nguyen", "30min 45sec", "10 Mar, 8:25 am ", R.drawable.avatarstatus_1),
            CallListDetails("Robert Fox", "30min 45sec", "10 Mar, 8:25 am ", R.drawable.avatarstatus_2),
            CallListDetails("Kristin Watson", "30min 45sec", "10 Mar, 8:25 am ", R.drawable.avatarstatus_3),
            CallListDetails("Marvin McKinney", "30min 45sec", "10 Mar, 8:25 am ", R.drawable.avatarstatus_4),
            CallListDetails("Floyd Miles", "30min 45sec", "10 Mar, 8:25 am ", R.drawable.avatarstatus_5),
            CallListDetails("Kathryn Murphy", "30min 45sec", "10 Mar, 8:25 am ", R.drawable.avatarstatus_6),
            CallListDetails("Wade Warren", "30min 45sec", "10 Mar, 8:25 am ", R.drawable.avatarstatus_7),
            CallListDetails("Cameron Williamson", "30min 45sec", "10 Mar, 8:25 am ", R.drawable.avatarstatus_8),
            CallListDetails("Darshan", "30min 45sec", "10 Mar, 8:25 am ", R.drawable.avatarstatus_2),
            CallListDetails("Darshan", "30min 45sec", "10 Mar, 8:25 am ", R.drawable.avatarstatus_3),
            CallListDetails("Darshan", "30min 45sec", "10 Mar, 8:25 am ", R.drawable.avatarstatus_4),
        )
    }
}