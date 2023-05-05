package com.example.kotlinpracticeandroid

enum class Direction {
    North,
    South,
    East,
    West
}

enum class NumberOfVehicle(val no: String) {

    Bike(no = "GJ03XXXX"),
    Car(no = "GJ05XXXX"),
    Truck(no = "Gj01XXXX")

}

var numberOfVehicle = NumberOfVehicle.Bike
var bikeNumber = NumberOfVehicle.Bike.no

enum class Cards(val color: String) {

    Diamond("red"),
    Heart("red"),
    Spades("black"),
    Club("black")

}

enum class Days {

    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday

}

enum class Season(private val effect: String) {

    Winter("Cold") {
        override fun effected() {
            println("this season is winter and this is cool season")
        }
    },
    Monsoon("Rainy") {
        override fun effected() {
            println("this season is monsoon and this is rainy season")
        }
    },
    Summer("Heat") {
        override fun effected() {
            println("this season is summer and this is heat season")
        }
    };

    abstract fun effected()

}

@JvmInline
value class Adding(val name: String)

fun main() {

    val adding = Adding("Darshan")
    println(adding)
    println(numberOfVehicle)
    val color = Cards.Diamond.color
    println(bikeNumber)
    println(color)

    for (i in Days.values()) {
        println(i.name)
    }

    fun foo() {}
    var win = Season.Winter.effected()

    for (i in Days.values()) {
        println(i)
    }

    val days = Days.Sunday
    println(Days.valueOf("Sunday"))
    when (days) {
        Days.Monday -> println("Today is Monday")
        Days.Tuesday -> println("Today is Tuesday")
        Days.Wednesday -> println("Today is Wednesday")
        Days.Thursday -> println("Today is Thursday")
        Days.Friday -> println("Today is Friday")
        Days.Saturday -> println("Today is Saturday")
        Days.Sunday -> println("Today is Sunday")
    }

}

