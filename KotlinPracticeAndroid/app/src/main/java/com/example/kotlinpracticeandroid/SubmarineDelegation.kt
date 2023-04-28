package com.example.kotlinpracticeandroid

import com.example.kotlinpracticeandroid.submarine.Coordinate
import com.example.kotlinpracticeandroid.submarine.ControlSystem
import com.example.kotlinpracticeandroid.submarine.MissileLauncher
import com.example.kotlinpracticeandroid.submarine.Submarine

class ControlSystemImpl: ControlSystem {
    private var speedOfSubmarine = 0 // 6
    private var coordinateOfSubmarine: Coordinate = Coordinate(0, 0) //8 (current location)

    override var autoPilot: Boolean = true
    var fuelMeter: Int = 0


    override fun detectEnemy(frequency: Int) {
        if (frequency > 500) { //10
            changeSpeed(-10)
            MissileLauncher.launchMissile = false
        }

        if (frequency < 200) {
            attackAlarm() //11
            attack()
            autoPilot = false
        }
    }

   fun changeSpeed(speed: Int) { //13
        this.speedOfSubmarine += speed
    }

    override fun currentLocation(ordinate: Coordinate) {
        coordinateOfSubmarine = Coordinate(ordinate.x, ordinate.y)
        navigationOfSubmarine(coordinateOfSubmarine)
    }

    private fun attack() { //15
        MissileLauncher.launchMissile = true
        println("Missile is Launch: ${MissileLauncher.launchMissile}")
    }

    private fun attackAlarm() {
        println("Enemy is near about us")
    }

    fun navigationOfSubmarine(coordinate: Coordinate) = when {
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

fun main() {
    val ordinate = Coordinate(-90,80)
    val submarineControlSystem = ControlSystemImpl()
    val submarine = Submarine(controlSystem = ControlSystemImpl())
    //submarine.changeSpeed(25)
    submarine.detectEnemy(99)
    println(submarine.autoPilot)
}