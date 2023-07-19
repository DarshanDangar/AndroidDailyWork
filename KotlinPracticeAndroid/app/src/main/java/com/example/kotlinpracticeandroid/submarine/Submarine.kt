package com.example.kotlinpracticeandroid.submarine

class Submarine(
    private val captain: Captain,
    private val submarineController: ControlSystem,
    private val fuelSystem: FuelSystem,
    private val missileLauncher: MissileLauncher
) {

    init {
        submarineController.setMissileLauncher(missileLauncher::launchMissile)
    }

    private val listOfFakeCoordinates = listOf(
        Coordinate(10, 30),
        Coordinate(20, 50),
        Coordinate(30, 60),
        Coordinate(40, 80),
        Coordinate(50, 90)
    )

    fun startSubmarine() {
        println("Submarine Started...")
        captain.controlSubmarine()
        startNavigating()
    }

    private fun startNavigating() {
        for (coordinate in listOfFakeCoordinates) {
            submarineController.navigateTo(coordinate)
            updateFuelDetails()
        }
    }

    private fun updateFuelDetails() {
        submarineController.notifyDistanceInFuelSystem { distance ->
            fuelSystem.onReceiveDistance(distance)
        }
    }

}

