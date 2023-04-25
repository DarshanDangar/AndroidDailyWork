package com.example.kotlinpracticeandroid

class Airport(var name: String, var type: String, var address: String, var isFlightAvailable: Boolean) {
    fun allDeatils() {
        println("Airport name is: $name, Airport type is: $type, Airport place is: $address, Flight is Available: $isFlightAvailable")
    }
}

fun main() {
    val airport = Airport("RajkotAirport", "International Airport", "Jamnagar road", true)

    println(airport.name)

    airport.run {
        this.type = "National"
        this.isFlightAvailable = false
    }
    println(airport.type)
    println(airport.isFlightAvailable)

    airport.also {
        it.type = "Inter"
    }
    println(airport.type)
    println(airport.isFlightAvailable)
}