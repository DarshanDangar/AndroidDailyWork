package com.example.kotlinpracticeandroid.submarine

import kotlin.properties.Delegates

open class SubmarineController : ControlSystem {

    var submarineSpeed: Int by Delegates.observable(0) { _, oldValue, newValue ->
        println("old speed is: $oldValue and New value is: $newValue")
    }

    private var coordinateOfSubmarine: Coordinate = Coordinate(0, 0)

    var getSubmarinCurrentLocation = navigationOfSubmarine(coordinateOfSubmarine)

    private val notifyOfficerOfAttack = { alarmOfAttack() }

    override var autoPilot: Boolean by Delegates.observable(false) { _, _, new ->
        if (new) {
            changeSpeedOfSubmarin(10)
        }
    }

    private fun changeSpeedOfSubmarin(speed: Int) {
        submarineSpeed += speed
    }

    var numbersOfMissileInSubmarine = Missile().missileCount

    override fun detectEnemy(frequency: Int) {
        when (frequency) {
            in 200..500 -> {
                Captain.changeSpeedOfSubmarin(-10)
                MissileLauncher.launchMissile = false
            }
            in 0..200 -> {
                notifyOfficerOfAttack()
                Captain.attackOnEnemy()  //lambda
                Captain.changeSpeedOfSubmarin(-10)
                if (numbersOfMissileInSubmarine < 10) {
                    notifyForHelp(coordinateOfSubmarine)
                }
                autoPilot = false
            }
        }
    }

    override fun currentLocation(ordinate: Coordinate) {
        coordinateOfSubmarine = Coordinate(ordinate.x, ordinate.y)
        navigationOfSubmarine(coordinateOfSubmarine)
    }

    val notifyOfFuelLevelIsLow =  {
        //println()
        FuelSystem.fuelDetailNotification("Fuel level is low please add fuel")
    }

    fun alarmOfAttack() {
        println("Enemy is near us") //
    }

    private fun notifyForHelp(location: Coordinate) {
        println("Notify successfully this $location")
    }

    fun notifyForMissileHelp(message: String) {
        println(message)
    }

    fun navigationOfSubmarine(coordinate: Coordinate): String = when {
        coordinate.x in 0..90 && coordinate.y == 0 -> "East"
        coordinate.x in -90..0 && coordinate.y == 0 -> "West"
        coordinate.y in 0..90 && coordinate.x == 0 -> "North"
        coordinate.y in -90..0 && coordinate.x == 0 -> "South"
        coordinate.x in 0..90 && coordinate.y in 0..90 -> "NorthEast"
        coordinate.x in -90..0 && coordinate.y in 0..90 -> "NorthWest"
        coordinate.x in -90..0 && coordinate.y in -90..0 -> "SouthWest"
        coordinate.x in 0..90 && coordinate.y in -90..0 -> "SouthEast"
        else -> "please add coordinate expectedly"
    }

}