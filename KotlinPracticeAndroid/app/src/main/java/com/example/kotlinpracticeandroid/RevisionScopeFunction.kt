package com.example.kotlinpracticeandroid

class Airport(
    var name: String,
    var type: String,
    private var address: String,
    var isFlightAvailable: Boolean,
) {
    fun airportDetails() {
        println("Airport name is: $name, Airport type is: $type, Airport place is: $address, Flight is Available: $isFlightAvailable")
    }
}

fun main() {
    val airport = Airport("RajkotAirport", "International Airport", "Jamnagar road", true)

    println(airport.name)

    airport.run {
        type = "National"
        isFlightAvailable = false
    }
    println(airport.type)
    println(airport.isFlightAvailable)

    airport.also {
        it.type = "Inter"
    }
    println(airport.type)
    println(airport.isFlightAvailable)

    Airport("Ahmedabad International airport", "International", "Near Rto", true).apply {
        type = "National"
        println(type)
    }
    val isFlightAvailable = with(airport) {
        println(type)
        println(name)
        println(isFlightAvailable)
        airportDetails()
        isFlightAvailable
    }
    println(isFlightAvailable)
    Airport("", "", "", false).also {
        println("This is farzy Airport")
    }
}