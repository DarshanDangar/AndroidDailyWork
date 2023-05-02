package com.example.kotlinpracticeandroid.submarine

import kotlin.properties.Delegates

class SubmarineController(private val missileLauncher: MissileLauncher) : ControlSystem { // missile

    private val listOfFrequency = listOf(505, 800, 100, 300, 900) //fake

    private var submarineSpeed: Int by Delegates.observable(25) { _, oldValue, newValue ->
        when {
            newValue < 0 -> {
                submarineSpeed = 0
                println("old speed is: $oldValue and New value is: $submarineSpeed")
            }
            newValue > 0 -> {
                println("old speed is: $oldValue and New value is: $submarineSpeed")
            }
        }
    }


//    val fuelMeterUpdate = {fuelSystem: FuelSystemImpl ->
//        fuelSystem.changeFuelMeter()
//    }

    var currentLocation: Coordinate by Delegates.observable(Coordinate(0, 0)) { _, old, new ->
        println("Notify successfully this $new")
       val coveredDistance = (new.x - old.x) + (new.y - old.y)
        //notifyDistanceCovered
    }

//    var currentDirectionOfSubmarine: String = ""
//        get() = getSubmarinCurrentLocation(coordinateOfSubmarine)

    override var autoPilot: Boolean by Delegates.observable(false) { _, _, new ->
        if (new) {
            submarineSpeed = 10
        }
    }

    fun changeSpeedOfSubmarin(speed: Int) { // private
        submarineSpeed += speed
    }

    //var numbersOfMissileInSubmarine = missileCount

    override fun onReceiveFrequency(frequency: Int) {
        when (frequency) {
            in 200..500 -> {
                changeSpeedOfSubmarin(-10)
                missileLauncher.hasLaunchMissile = false
            }
            in 0..200 -> {
                detectEnemy()
            }
        }
    }

    private fun detectEnemy() {
        notifyOfAttack()
        attackOnEnemy()
        autoPilot = false
        changeSpeedOfSubmarin(-10)
        missileLauncher.hasLaunchMissile = true
    }

//    override fun currentLocation(ordinate: Coordinate) {
//        currentLocation = Coordinate(ordinate.x, ordinate.y) // sa
//        getSubmarinCurrentLocation(currentLocation) // useless
//    }

//    val notifyOfFuelLevelIsLow = { captain: Captain, fuelType: FuelSystem -> // dought
//        captain.fillFuelInSubmarine(fuelType)
//    }

    private fun notifyOfAttack() { // na
        println("Enemy is near us") //
    }

//    fun notifyForMissileHelp(message: String) {
//        println(message)
//    }

    override fun navigateTo(ordinate: Coordinate) {
        currentLocation = ordinate
        onReceiveFrequency(listOfFrequency.random()) // onReceiveFrequency
    }

//    fun notifyForHelp(location: Coordinate) {
//        println("Notify successfully this $location")
//    }

//    private fun getSubmarinCurrentLocation(coordinateOfSubmarine: Coordinate): String = when {
//        coordinateOfSubmarine.x in 0..90 && coordinateOfSubmarine.y == 0 -> "East"
//        coordinateOfSubmarine.x in -90..0 && coordinateOfSubmarine.y == 0 -> "West"
//        coordinateOfSubmarine.y in 0..90 && coordinateOfSubmarine.x == 0 -> "North"
//        coordinateOfSubmarine.y in -90..0 && coordinateOfSubmarine.x == 0 -> "South"
//        coordinateOfSubmarine.x in 0..90 && coordinateOfSubmarine.y in 0..90 -> "NorthEast"
//        coordinateOfSubmarine.x in -90..0 && coordinateOfSubmarine.y in 0..90 -> "NorthWest"
//        coordinateOfSubmarine.x in -90..0 && coordinateOfSubmarine.y in -90..0 -> "SouthWest"
//        coordinateOfSubmarine.x in 0..90 && coordinateOfSubmarine.y in -90..0 -> "SouthEast"
//        else -> "please add coordinate expectedly"
//    }

    fun attackOnEnemy() {
        missileLauncher.hasLaunchMissile = true
        println("Missile is Launch: ${missileLauncher.hasLaunchMissile}")
    }

}