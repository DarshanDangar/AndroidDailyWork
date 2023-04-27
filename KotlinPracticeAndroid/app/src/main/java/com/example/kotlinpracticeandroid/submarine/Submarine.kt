package com.example.kotlinpracticeandroid.submarine

import kotlin.properties.Delegates

open class Submarine : ControlSystem {

    private var submarineSpeed: Int by Delegates.observable(0) { _, oldValue, newValue ->
        println("old speed is: $oldValue and New value is: $newValue")
    }

    private var coordinateOfSubmarine: CoOrdinates = CoOrdinates(0, 0)
    private val notifyOfficerOfAttack = { alarmOfAttack() }

    override var autoPilot: Boolean = true

    override var fuelMeter: Int by Delegates.observable(5) { _, _, newValue ->
        if (newValue < 2) {
            fillFuelInSubmarine(FuelSystem)
        }
    }

    override fun detectEnemy(frequency: Double) {
        if (frequency > 500) {
            changeSpeed(-10)
            Missile.launchMissile = false
        }

        if (frequency < 200) {
            notifyOfficerOfAttack
            attackOnEnemy()
            notifyForHelp(coordinateOfSubmarine)
            autoPilot = false
        }
    }

    override fun changeSpeed(speed: Int) {
        submarineSpeed += speed
    }

    override fun navigation(ordinate: CoOrdinates) {
        coordinateOfSubmarine = CoOrdinates(ordinate.x, ordinate.y)
        navigationOfSubmarine(coordinateOfSubmarine)
    }

    private fun attackOnEnemy() {
        Missile.launchMissile = true
        println("Missile is Launch: ${Missile.launchMissile}")
    }

    private fun alarmOfAttack() {
        println("Enemy is near about us")
    }

    private fun notifyForHelp(location: CoOrdinates) {
        println("Notify successfully this $location")
    }

    fun navigationOfSubmarine(coordinate: CoOrdinates): String = when {
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

    private fun fillFuelInSubmarine(fuelType: FuelSystem) {
        println("Fuel Added")
        println("Submarine Fuel type is: ${fuelType.fuelType} and it's Capacity is: ${fuelType.capacity}")
    }
}

fun main() {
    val ordinate = CoOrdinates(80, 0)
    val submarine = Submarine().apply {
        fuelMeter = 1
        println("Apply scope function use: $this")
    }.navigationOfSubmarine(ordinate).let {
        println("Direction is: $it")
    }
}
