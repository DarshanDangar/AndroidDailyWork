package com.example.kotlinpracticeandroid

enum class Direction {

    North, South, East, West

}

enum class NumberOfVehicle(val no: String) {

    Bike(no = "GJ03XXXX"), Car(no = "GJ05XXXX"), Truck(no = "Gj01XXXX")

}

var numberOfVehicle = NumberOfVehicle.Bike
var bikeNumber = NumberOfVehicle.Bike.no

enum class Cards(val color: String) {

    Diamond("red"), Heart("red"), Spades("black"), Club("black")

}

enum class Days(val no: Int) {

    Monday(1), Tuesday(2), Wednesday(3), Thursday(4), Friday(5), Saturday(6), Sunday(7)

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

//enum class DayOfWeek(val displayName: String) {
//    SUNDAY("Sunday"), // ordinal = 0
//    MONDAY("Monday"), // ordinal = 1
//    TUESDAY("Tuesday") {
//        override val ordinal: Int
//        get() = 42 // Assigning a preferred ordinal value
//        },
//     // ... other constants
//}

fun main() {

    val day = Days.Monday
    val t = when (Days.Monday.no) {
        1 -> println("Never")
        2 -> println("Used")
        else -> println("d")
    }
    println(t)
    println(day.ordinal)
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

