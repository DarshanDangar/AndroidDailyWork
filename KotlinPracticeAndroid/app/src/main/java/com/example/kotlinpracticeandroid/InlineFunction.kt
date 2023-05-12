package com.example.kotlinpracticeandroid

inline fun isSmartphone(function: () -> Unit, lmb: () -> Unit) {
    println("yes")
    function()
    lmb()
}

open class HJKL {}

fun HJKL.add() {
    println("Added.....")
}

class JK: HJKL() {

}

inline fun isComplete(complete: () -> Unit, noinline notComplete: () -> Unit) {
    complete()
    notComplete()
}

inline fun isBusy(available: () -> Unit, crossinline busy: () -> Unit) {
    available()
    busy()
    println("Hello")

}

var x
    inline get() = 5
    set(value) {
        x = value
    }

inline fun ad(num: Int, lm: (Int) -> Unit) {
    lm(num)
}

fun main() {
    val jk = JK()
    jk.add()
    ad(5) {
        println(it)
    }
    isSmartphone({ println("smartphone") }, { println("Lambdas") })
    isComplete({ println("Work is complete") }, { println("Work is not complete") })
    isBusy({
        println("Available")
        return
    },
        {
            println("Busy")
        }
    )
}

