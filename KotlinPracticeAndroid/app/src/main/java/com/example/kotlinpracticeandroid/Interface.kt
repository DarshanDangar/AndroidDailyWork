package com.example.kotlinpracticeandroid

interface Engine {

    var condition: Int
    var maaterial: String

    fun isComplete()
    fun price() {
        println("car price is:120k")
    }

}

class Car(override var condition: Int, override var maaterial: String) : Engine {

    override fun isComplete() {
        if(condition > 80) {
            println("car condition is good so it's price heavy")
        }
    }

//    override fun price() {
//        super.price()
//        println("Car price is 35% off by car road price")
//    }

}

fun main() {

    val car = Car(85,"StainlessSteel")
    car.isComplete()
    car.price()

    val price = AboutPrice()
    println(price.useMaterial)
    println(price.buildingType)
    println(price.price)
    xyz = 50 // ClassInstance file ma 37
    println(internalProperty)

}

// interface inheritance

interface Building {

    val buildingType: String
    val useMaterial: String

}

interface House: Building {

    override val buildingType: String
        get() = "RawHouse"

    override val useMaterial: String
        get() = "Best quality"

    val price: Long

}

class AboutPrice: House {

    override val price: Long
        get() = 25000000

}




