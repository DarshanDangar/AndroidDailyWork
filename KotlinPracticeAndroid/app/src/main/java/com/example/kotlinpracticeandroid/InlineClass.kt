package com.example.kotlinpracticeandroid

@JvmInline
value class NameOfStudent(val name: String) {
    init {
        println("initialized")
    }
}

@JvmInline
value class Mobile(val storageCapacity: String): Apple {
    override fun price() {
        println("Mobile price is depending on storage capacity")
    }
}

interface Apple {
    fun price()
}

@JvmInline
value class ConvertSquare(val num: Int) {

}

fun main() {
    var studentName = NameOfStudent("Darshan")
    println(studentName)
    val samsung = Mobile("128 Gb")
    println(samsung)
    samsung.price()
    println(samsung.storageCapacity)
}