package com.example.kotlinpracticeandroid

class Example {

    private val isExampleRight = true

    inner class SubExample {
        fun giveAnswerOuterClass() {
            if (isExampleRight) println("Example is right")
        }
    }

}

object Pilot {

    var pilotName: String = "BHJ"

}

class Name(a: Integer) {

}

val aa = arrayOf(5, 10, 2.0, 5.00, 5.0f, 5L)

val nameStringn = listOf("Darshan", "Shyam", "Shubham")
val dd = nameStringn.map {
    it[4]
}

fun main() {
    println(dd)
    val name = Name(Integer(10))
    Pilot.pilotName
    println(Pilot.pilotName)
    Pilot.pilotName = "Darshan"
    println(Pilot.pilotName)
    println(Pilot)
    val subExample = Example().SubExample()
    subExample.giveAnswerOuterClass()
}