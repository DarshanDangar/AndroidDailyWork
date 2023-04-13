package com.example.kotlinpracticeandroid

// Control flow

// if expression

var number = 5
var digit = 6
var max = 0


var othernumber: Int = 8
var maximum = if (number > digit) number else if (digit > othernumber) digit else othernumber

// when expression

var ageofPerson = 55
var resultPerson = when(ageofPerson) {
    in 19..100 -> println("You are eligible for voting")
    in 1..18 -> println("You are not eligible for voting")
    else -> println("please enter valid digit")
}

// for loop

var personArray = arrayOf("Darshan", "Shyam", "Shubham")

fun main() {
    if (number < digit) max = digit
    println(max)
    max = if (number > digit) number else digit
    println(maximum)
    println(resultPerson)

    for (i in personArray) {
        println(i)
    }

    for (i in 1..5) {
        println(i)
    }

    for (i in 6 downTo 0 step 4) {
        println(i)
    }

    for (i in 1 until 10 step 3) {
        println(i)
    }

    for (i in (0..4).reversed()) {
        println(i)
    }
}

