package com.example.kotlinpracticeandroid.submarine

class Submarine(
    captain: Captain,
    val submarineController: ControlSystem,
    val fuelSystem: FuelSystem
) {

    private val listOfCoordinates = listOf(
        Coordinate(10, 30),
        Coordinate(20, 50),
        Coordinate(30, 60),
        Coordinate(40, 80),
        Coordinate(50, 90)
    )

    fun startSubmarine() {
        println("Submarine Started...")
        nextNavigation()
    }

    private fun nextNavigation() { // startNavigating
        for (coordinate in listOfCoordinates) {
            submarineController.navigateTo(coordinate) // navigateTo

        }
    }

}

