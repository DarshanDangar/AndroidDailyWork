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

fun main() {
    Pilot.pilotName
    println(Pilot.pilotName)
    Pilot.pilotName = "Darshan"
    println(Pilot.pilotName)
    println(Pilot)
    val subExample = Example().SubExample()
    subExample.giveAnswerOuterClass()

}