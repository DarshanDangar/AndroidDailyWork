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
    var pilot = Pilot.pilotName
    println(pilot)
    var plt = Pilot.pilotName
    plt = "dar"
    println(plt)
    println(pilot)
    val subExample = Example().SubExample()
    subExample.giveAnswerOuterClass()

}