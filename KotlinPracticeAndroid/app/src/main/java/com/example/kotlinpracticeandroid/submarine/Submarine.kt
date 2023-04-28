package com.example.kotlinpracticeandroid.submarine

class Submarine(private val controlSystem: ControlSystem) : ControlSystem by controlSystem //

fun main() {

    //val ordinate = CoOrdinate(80, 0)
//    val submarine = Submarine().apply {
//        fuelMeter = 1
//        detectEnemy(100.0)
//        println("Apply scope function use: $this")
//    }.navigationOfSubmarine(ordinate).let {
//        println("Direction is: $it")
//    }

    val controlSystem = SubmarineController()
    val submarine = Submarine(controlSystem)
    submarine.detectEnemy(10)
    //Pilot.changeSpeed(25 )
    Captain.changeSpeedOfSubmarin(50)
    submarine.currentLocation(Coordinate(80, 90))
    println(FuelSystem.fuelMeter)
    println(Captain.getSubmarinCurrentLocation)
    val missile = Missile()
    submarine.detectEnemy(20)
    println(missile.missileCount)
    submarine.detectEnemy(20)
    println(missile.missileCount)
    submarine.detectEnemy(20)
    println(missile.missileCount)
    submarine.detectEnemy(20)
    println(missile.missileCount)
    //FuelSystem.fuelMeter = 1




//    val supersubmarine = Submarine(controlSystem).apply {
//        autoPilot = false
//        changeSpeed(30)
//        println(this.autoPilot)
//    }.run {
//        this.changeSpeed(100)
//    }
//
//    Pilot.apply {
//        println(pilotName)
//    }.also {
//
//    }

    //Pilot.submarineSpeed = 25
}
