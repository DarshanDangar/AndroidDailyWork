package com.example.kotlinpracticeandroid

fun interface Ship {
    fun type(type: String): String
}

fun interface Even {
    fun even(num: Int): Boolean
}

val isevenRes = Even {
    it % 2 == 0
}

val addition = {num1: Int, num2: Int -> num1 + num2}
val propertyLazy by lazy{ addition}

fun main() {
    println(addition(10,12))

    val shiptype = Ship { "cruse" }
    println(shiptype.type(""))

    fun even(num: Int) {
        if (num % 2 == 0) {
            println("$num is even")
        } else {
            println("$num is odd")
        }
    }


    even(2)

    println(isevenRes.even(2))

    fun add(num1: Int, num2: Int) {
        println(num1 + num2)
    }

    add(5,4)

}