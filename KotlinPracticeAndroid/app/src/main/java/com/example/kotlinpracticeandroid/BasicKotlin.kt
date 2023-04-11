package com.example.kotlinpracticeandroid

//val digit = 15
//var number = 20

val byte: Byte = 10
val short: Short = 20

val floatdigit = 20.5f
val doubleDigit = 52.6

val longDigit = 45645231L

// Array

var mark = arrayOf(5, 4, 6, 9, 8, 5, 7, "Darshan")

var intArray = intArrayOf(5, 10, 15, 20, 25, 30)

var charArray = charArrayOf('g', 's', 'r', 't', 'c')

var stringArray = arrayOf("Darshan", "Shyam", "Shubham")

// String

val firstName = "Darshan"
val lastName = "Dangar"
val fullName = "$firstName $lastName"


// if else

val age = 19
val result = if (age > 18) {
    "you are eligible for voting"
} else {
    "you are not eligible for voting"
}

// when

val Digit = 15
val digitN = 10
val operator = "/"

//val resultOp = when (operator) {
//
//}

// program entery point

fun main(args: Array<String>) {
    println("Hello")
    println("${fullName.length}")
    println(result)
    println(sum(5, 4))
    add(8, 9)
    sub(5, 4)
}

fun sum(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun add(digit1: Int, digit2: Int) {
    println(digit1 + digit2)
}

fun sub(num1: Int, num2: Int): Unit {
    println(num1 * num2) // unit is this function rreturn no meaningful value
}

fun unnamed() {
    println("unnamed uses")
}