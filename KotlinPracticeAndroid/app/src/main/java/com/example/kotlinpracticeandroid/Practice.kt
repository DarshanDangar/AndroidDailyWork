package com.example.kotlinpracticeandroid

import kotlin.properties.Delegates

class Practice {

    var name: String = "Darshan"
        private set

    //get() = field
//    set(value) {
//        field = value
//    }
    fun ji() {
        name = "nkn"
    }

}

open class SystemPc(val name: String, val price: Int) {

    open val add = 5

    constructor(name: String, price: Int, weight: Int) : this(name, price)

    fun detail() {
        println("name is: $name and its price is $price")
    }
}

class Laptop(name: String, price: Int, val weight: Int) : SystemPc(name, price) {
    override var add: Int = 10

    constructor(name: String, price: Int, weight: Int, camera: Boolean) : this(
        name,
        price,
        weight
    ) {
        add = weight
    }
}

inline fun passLambdas(lambda: () -> Unit) {
    lambda()
}

inline fun passTwoLambdas(lambda1: () -> Unit, noinline lambda2: () -> Unit) {
    lambda1()
    lambda2()
}

fun main() {
    fun name(a: Int, b: (String) -> Unit) {
        println(a)
    }

    name(5) {
        println(it)
    }

    val pr = Practice()
    //pr.name = "Darshan"
    println(pr.name)
    val laptop = Laptop("Dell", 50000, 1, true)
    laptop.detail()

    fun numbers(vararg number: Int) {
        println(number)
    }
    numbers(1, 2, 3)

    // infix notation

    infix fun Int.isOdd(a: Int) {
        if (a % 2 == 0) {
            println(a)
        }
    }

    2 isOdd (5)

    //inline function

    passLambdas {
        println("Inline function use")
    }

    // noinline function

    val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    numberList.filter {
        it > 5
    }.also {
        println(it)
    }
    println(numberList)
    numberList.map {
        it * 5
    }.also {
        println(it)
    }

    val numbers = listOf("one", "two", "three", "four")
    val numbersIterator = numbers.iterator()
    println(numbersIterator.next())
    println(numbersIterator.next())
    println(numbersIterator.next())
    println(numbersIterator.next())
    for (i in numbers) {
        println(i)
    }
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }
    numbers.forEach {
        println(it)
    }

    val mobileNo = sequenceOf(99, 91, 101, 102, 501)
    println(mobileNo.iterator())

    // associateWith and associateBy

    val digitList = listOf("Darshan", "Shubham", "Shyam", "Priyanshu")
    println(digitList.associateWith {
        it.length
    })
    println(digitList.associateBy {
        it.first()
    })
    println(
        digitList.associateBy(
            keySelector = { it.first().uppercase() },
            valueTransform = { it })
    )

}