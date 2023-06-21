package com.example.firstandroidui

data class CallListDetails(
    val name: String,
    val timeDuration: String,
    val dateAndTime: String
)

class DataCallList {
    companion object {
        val listofCall: List<CallListDetails> = listOf(
            CallListDetails("Darshan","30min 45sec","30min 45sec"),
            CallListDetails("Darshan","30min 45sec","30min 45sec"),
            CallListDetails("Darshan","30min 45sec","30min 45sec"),
            CallListDetails("Darshan","30min 45sec","30min 45sec"),
            CallListDetails("Darshan","30min 45sec","30min 45sec"),
            CallListDetails("Darshan","30min 45sec","30min 45sec"),
            CallListDetails("Darshan","30min 45sec","30min 45sec"),
            CallListDetails("Darshan","30min 45sec","30min 45sec"),
            CallListDetails("Darshan","30min 45sec","30min 45sec"),
            CallListDetails("Darshan","30min 45sec","30min 45sec"),
            CallListDetails("Darshan","30min 45sec","30min 45sec"),
        )
    }
}