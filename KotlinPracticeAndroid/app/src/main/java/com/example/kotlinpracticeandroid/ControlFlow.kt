package com.example.kotlinpracticeandroid

val number = 5
val digit = 6
var max = 0

val otherNumber: Int = 8
val maximum = if (number > digit) number
else if (digit > otherNumber) digit else otherNumber

val ageOfPerson = 55
val resultPerson = when (ageOfPerson) {
    in 19..100 -> println("You are eligible for voting")
    in 1..18 -> println("You are not eligible for voting")
    else -> println("please enter valid digit")
}

var personArray = arrayOf("Darshan", "Shyam", "Shubham")

fun main() {

    if (number < digit) max = digit
    println(max)

    max = if (number > digit) number else digit
    println(maximum)
    println(resultPerson)

    for (element in personArray) {
        println(element)
    }

    for (element in 1..5) {
        println(element)
    }

    for (element in 6 downTo 0 step 4) {
        println(element)
    }

    for (element in 1 until 10 step 3) {
        println(element)
    }

    for (element in (0..4).reversed()) {
        println(element)
    }

}

