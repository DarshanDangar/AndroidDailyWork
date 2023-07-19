package com.example.kotlinpracticeandroid

fun greeting(name: String) {
    println("Hello $name")
}

fun voting(name: String, age: Int, address: String, available: Boolean) {
    println("Voter is available: $available")
    println("voter name is $name, it's age is $age and $name address is: $address")
}

fun isOpen(name: String = "", available: Boolean) {
    if (available) {
        println("$name is available")
    }
}

open class Amc {

    open fun isOpen(open: Boolean = true) {
        if (open) {
            println("Amc is open")
        } else {
            println("Amc is closed")
        }
    }

}

class Amts : Amc() {

    override fun isOpen(open: Boolean) {
        if (open) {
            println("Amts is running")
        } else {
            println("Amts is not running today")
        }
    }

}

fun cube(num: Int) {
    println(num * num * num)
}

fun square(num: Int): Int = num * num

fun isBusy() = println("Yes, this man busy")

fun area(num: Int) = num *
        3.14 * num

val voter = voting("Darshan", 21, "Mota Dadva", true)

fun varargs(vararg num: Int): IntArray {
    return num
}

// infix notation

//infix fun address(address: String) {}

// local or nested function

fun mrp() {
    var wetTex: Int = 0
    fun price() {
        wetTex = 15
        val price = 500
        println("price: $price")
    }

    fun tax() {
        println("tex is depend type of product")
    }

}

// member function is fun is in a class or object

class CyberCrime {
    fun crimeRate(crimeRate: Double) {
        println("crimeRate is: $crimeRate")
    }
}

// generic function

fun <T> generic(value: T): T {
    return value
}

// tail recursion

tailrec fun factTail(num: Int, product: Int): Int {
    return if (num == 1)
        product
    else
        factTail(num - 1, product * num)
}

fun main() {
    val arrayOfInt = arrayOf(5, 4, 6, 3, 2, 1)
    val resFact = factTail(5, 1)
    println(resFact)
    CyberCrime().crimeRate(15.5)
    mrp()
    val amts = Amts()
    val typeChecking = amts.isOpen()
    if (typeChecking is Unit) {
        println(typeChecking)
    }
    greeting("Darshan")
    println(voter)
    isOpen(available = true, name = "Shyam")
    val cube = cube(3)
    println(cube)
    println(square(4))
    isBusy()
    println(area(5))
    val area = area(6)
    if (area is Double) {
        println("Area is double type")
    }
    var d: Array<Int> = arrayOf(9, 8, 7)
    val resultVararg = varargs(5, 4, 6, 8, 2, 4)
    for (i in resultVararg) {
        println(i)
    }
    val myName: String by lazy {
        "Darshan"
    }
    println(myName)
    var generic: Any = generic(5)
    println(generic)
    generic = generic("Darshan")
    println(generic)
    print(generic)

}