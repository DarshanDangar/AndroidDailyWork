package com.example.kotlinpracticeandroid

import com.example.kotlinpracticeandroid.ConvertIntNumber as ConvertIntNumber

@JvmInline
value class NameOfStudent(val name: String) {

    init {
        println("initialized")
    }

}

@JvmInline
value class SmartPhone(val storageCapacity: String) : Apple {

    override fun price() {
        println("Mobile price is depending on storage capacity")
    }

}

interface Apple {
    fun price()
}

@JvmInline
value class ConvertIntNumber(val num: Int)

fun main() {
    val studentName = NameOfStudent("Darshan")
    println(studentName)
    val samsung = SmartPhone("128 Gb")
    println(samsung)
    samsung.price()
    println(samsung.storageCapacity)
    val numSquare = ConvertIntNumber(2)
    println(numSquare.num)
}