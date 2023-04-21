package com.example.kotlinpracticeandroid

// class and instance

class Area(var radius: Int) {
    companion object {
        val ct: String by lazy {

            ""
        }
    }
    var area = radius * radius
    fun printArea(){
        println(area)
    }
    fun max(digit1: Int, digit2: Int): Int {
        if (digit1 > digit2){
            return digit1
        } else {
            return digit2
        }
    }

    fun min(digit1: Int, digit2: Int) = if (digit1 < digit2) digit1 else digit2

    val iteam = listOf("Apple", "Banana", "Guavava")

}

fun main() {
    var area = Area(5)
    area.printArea()
    println(area.max(10,12))
    for (i in area.iteam) {
        println(i)
    }
    for (i in area.iteam.indices) {
        println(i)
    }

    println(privateProperty)

}

public var xyz = 5
private var privateProperty = 500
internal var internalProperty = 5000 // use only same module(package) (app)