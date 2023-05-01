package com.example.kotlinpracticeandroid.submarine

import kotlin.properties.Delegates

open class SubmarineController: ControlSystem, MissileLauncher() {

    var submarineSpeed: Int by Delegates.observable(25) { _, oldValue, newValue ->
        if (newValue < 0) {
            submarineSpeed = 0
            println("old speed is: $oldValue and New value is: $submarineSpeed")
        }
    }

    var coordinateOfSubmarine: Coordinate by Delegates.observable(Coordinate(0,0)) {_ , _, new ->
        println("Notify successfully this $new")
    }

    var currentDirectionOfSubmarine: String = ""
        get() = getSubmarinCurrentLocation(coordinateOfSubmarine)


    private val notifyOfficerOfAttack = { alarmOfAttack() }

    override var autoPilot: Boolean by Delegates.observable(false) { _, _, new ->
        if (new) {
            submarineSpeed = 10
        }
    }

    fun changeSpeedOfSubmarin(speed: Int) {
        submarineSpeed += speed
    }

    //var numbersOfMissileInSubmarine = MissileCounter().missileCount

    override fun detectEnemy(frequency: Int) {
        when (frequency) {
            in 200..500 -> {
                changeSpeedOfSubmarin(-10)
                hasLaunchMissile = false
            }
            in 0..200 -> {
                notifyOfficerOfAttack()
//                captain.attackOnEnemy()  //lambda
                changeSpeedOfSubmarin(-10)
                autoPilot = false
            }
        }
    }

    override fun currentLocation(ordinate: Coordinate) {
        coordinateOfSubmarine = Coordinate(ordinate.x, ordinate.y)
        getSubmarinCurrentLocation(coordinateOfSubmarine)
    }

    val notifyOfFuelLevelIsLow =  {
        //println()
        //fuelDetailNotification("Fuel level is low please add fuel")
    }

    fun alarmOfAttack() { // na
        println("Enemy is near us") //
    }

    fun notifyForMissileHelp(message: String) {
        println(message)
    }

//    fun notifyForHelp(location: Coordinate) {
//        println("Notify successfully this $location")
//    }

    fun getSubmarinCurrentLocation(coordinateOfSubmarine: Coordinate): String = when {
        coordinateOfSubmarine.x in 0..90 && coordinateOfSubmarine.y == 0 -> "East"
        coordinateOfSubmarine.x in -90..0 && coordinateOfSubmarine.y == 0 -> "West"
        coordinateOfSubmarine.y in 0..90 && coordinateOfSubmarine.x == 0 -> "North"
        coordinateOfSubmarine.y in -90..0 && coordinateOfSubmarine.x == 0 -> "South"
        coordinateOfSubmarine.x in 0..90 && coordinateOfSubmarine.y in 0..90 -> "NorthEast"
        coordinateOfSubmarine.x in -90..0 && coordinateOfSubmarine.y in 0..90 -> "NorthWest"
        coordinateOfSubmarine.x in -90..0 && coordinateOfSubmarine.y in -90..0 -> "SouthWest"
        coordinateOfSubmarine.x in 0..90 && coordinateOfSubmarine.y in -90..0 -> "SouthEast"
        else -> "please add coordinate expectedly"
    }

    companion object {
        var numbersOfMissileInSubmarine: Int = 0
    }

}