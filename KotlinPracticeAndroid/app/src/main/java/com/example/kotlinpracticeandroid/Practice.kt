package com.example.kotlinpracticeandroid

class Practice {

    var name: String = "Darshan"
        private set

    fun details() {
        name = "nkn"
    }

}

open class SystemPc(val name: String, private val price: Int) {

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

val addTwoNumber = { num1: Int, num2: Int -> num1 + num2 }

fun add(num1: Int, num2: (Int) -> Unit) {
    num2(num1)
}

fun minus(num1: Int, num2: Int) {
    println(num2 - num1)
}

fun calculate(num1: Int, num2: Int, calculation: (Int, Int) -> Unit) {
    calculation(num1, num2)
}

val multiply: (Int, Int) -> Unit = { num1, num2 ->
    println(num1 * num2)
}

abstract class Isro {
    abstract fun launch()
    fun fly() {
        println("Fly")
    }
}

fun main() {

    calculate(5, 8, ::minus)
    calculate(10, 2, multiply)
    add(5) {
        println(it * it)
    }
    println(addTwoNumber(5, 10))
    fun name(age: Int, address: (String) -> Unit) {
        println(age)
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

    val numList = listOf(1,2,3,4,5,6)
    val d = numList.filter {
        it > 4
    }
        .map {
            println(it)
        }
        .take(2)
    println()

    val numListSequence = sequenceOf(1,2,3,4,5,6)
    val dd = numList.filter { it > 4
    }
        .map {
            println(it)
        }
        .take(2)
    println()

    val nameString = listOf("Shubham", "Darshan", "Shyam")
    val resultString = nameString.filter {
        it.length > 6
    }
        .map {
            println(it)
        }
        .take(2)
}
