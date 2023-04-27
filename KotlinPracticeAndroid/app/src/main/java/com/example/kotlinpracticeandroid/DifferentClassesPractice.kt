package com.example.kotlinpracticeandroid

class Example {
    private val isExampleRight = true

    inner class SubExample {
        fun giveAnswerOuterClass() {
            if (isExampleRight) println("Example is right")
        }
    }
}

fun main() {
    val subExample = Example().SubExample()
    subExample.giveAnswerOuterClass()
}