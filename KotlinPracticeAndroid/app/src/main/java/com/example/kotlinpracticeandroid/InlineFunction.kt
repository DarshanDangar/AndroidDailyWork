package com.example.kotlinpracticeandroid

inline fun isSmartphone(function: () -> Unit, lmb: () -> Unit) {
    println("yes")
    function()
    lmb()
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
        set(value){
            x = value
        }



fun main() {
    isSmartphone ({ println("smartphone") }, { println("lmbdas") })
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

