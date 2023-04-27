package com.example.kotlinpracticeandroid

import kotlin.properties.Delegates

interface ControlSystem {
    val autoPilot: Boolean
    var fuelMeter: Int
    fun detectEnemy(frequency: Double)
    fun changeSpeed(speed: Int)
    fun navigation(ordinate: CoOrdinates)
}

data class CoOrdinates(val x: Int, val y: Int)// 3

class Submarine: ControlSystem { //7

    private var submarineSpeed: Int by Delegates.observable(0) { _, oldValue, newValue ->
        println("old speed is: $oldValue and New value is: $newValue")
    } // 6

    //lateinit var direction: Direction
    lateinit var coordinateOfSubmarine: CoOrdinates  //8 (current location)
    private val notifyOfficerOfAttack = {alarmOfAttack()}

    override var autoPilot: Boolean = true //12

    override var fuelMeter: Int by Delegates.observable(5) {property, oldValue, newValue ->
        if (newValue < 2) {
            fillFuelInSubmarine()
        }
    }

    override fun detectEnemy(frequency: Double) {
        if (frequency > 500) { //10
            changeSpeed(-10)
            Missile.launchMissile = false
        }

        if (frequency < 200) {
            notifyOfficerOfAttack
            //alarmOfAttack() //11
            attackOnEnemy()
            autoPilot = false
        }
    }

    override fun changeSpeed(speed: Int) { //13
        submarineSpeed += speed
    }

    override fun navigation(coordinate: CoOrdinates) { //14
        coordinateOfSubmarine = CoOrdinates(coordinate.x, coordinate.y)
        direction(coordinateOfSubmarine)
    }

    private fun attackOnEnemy() { //15
        Missile.launchMissile = true
        println("Missile is Launch: ${Missile.launchMissile}")
    }

    private fun alarmOfAttack() {
        println("Enemy is near about us")
    }

//    val direction = { coordinateOfSubmarine: CoOrdinates ->
//        when(coordinateOfSubmarine.x) {
//            in  0..90 -> Direction.East
//            in -90..0 -> Direction.West
//        }
//        when(coordinateOfSubmarine.y){
//            in 0..90 -> Direction.North
//            in -90..0 -> Direction.South
//            else -> ""
//        }
//    }

    fun direction(coordinate: CoOrdinates): String {
        if (coordinateOfSubmarine.x in 0..90 && coordinateOfSubmarine.y == 0) {
            return "East"
        } else if (coordinateOfSubmarine.x in -90..0 && coordinateOfSubmarine.y ==0) {
            return "West"
        } else if (coordinateOfSubmarine.y in 0..90 && coordinateOfSubmarine.x == 0) {
            return "North"
        } else if (coordinateOfSubmarine.y in -90..0 && coordinateOfSubmarine.x == 0) {
            return "South"
        } else if (coordinateOfSubmarine.x in 0..90 && coordinateOfSubmarine.y in 0..90) {
            return "NorthEast"
        }  else if (coordinateOfSubmarine.x in -90..0 && coordinateOfSubmarine.y in 0..90) {
            return "NorthWest"
        }  else if (coordinateOfSubmarine.x in -90..0 && coordinateOfSubmarine.y in -90..0) {
            return "SouthWest"
        }  else if (coordinateOfSubmarine.x in 0..90 && coordinateOfSubmarine.y in -90..0) {
            return "SouthEast"
        } else {
            return "please add coordinate exectelly"
        }
    }

    fun fillFuelInSubmarine() {
        FuelSystem.fuelType
        FuelSystem.capacity
    }
}

object Missile {
    var launchMissile: Boolean = false //16
}

object FuelSystem {
    const val fuelType: String = "Uranium"
    const val capacity: Int = 20000
}

fun main() {
    val ordinate = CoOrdinates(80,0)
    val submarine = Submarine()
    //submarine.direction = Direction.South //18
    submarine.coordinateOfSubmarine = ordinate
    submarine.changeSpeed(25)
    submarine.detectEnemy(99.55)
    println(submarine.autoPilot)
    println(submarine.direction(ordinate))

}
