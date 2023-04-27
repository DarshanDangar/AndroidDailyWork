package com.example.kotlinpracticeandroid

import com.example.kotlinpracticeandroid.submarine.CoOrdinates
import com.example.kotlinpracticeandroid.submarine.ControlSystem
import com.example.kotlinpracticeandroid.submarine.Missile
import com.example.kotlinpracticeandroid.submarine.Submarine

class ControlSystemImpl: ControlSystem {
    private var speedOfSubmarine = 0 // 6
    private var coordinateOfSubmarine: CoOrdinates = CoOrdinates(0, 0) //8 (current location)

    override var autoPilot: Boolean = true
    override var fuelMeter: Int = 0


    override fun detectEnemy(frequency: Double) {
        if (frequency > 500) { //10
            changeSpeed(-10)
            Missile.launchMissile = false
        }

        if (frequency < 200) {
            attackAlarm() //11
            attack()
            autoPilot = false
        }
    }

    override fun changeSpeed(speed: Int) { //13
        this.speedOfSubmarine += speed
    }

    override fun navigation(ordinate: CoOrdinates) {
        coordinateOfSubmarine = CoOrdinates(ordinate.x, ordinate.y)
        navigationOfSubmarine(coordinateOfSubmarine)
    }

    private fun attack() { //15
        Missile.launchMissile = true
        println("Missile is Launch: ${Missile.launchMissile}")
    }

    private fun attackAlarm() {
        println("Enemy is near about us")
    }

    fun navigationOfSubmarine(coordinate: CoOrdinates) = when {
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
    val ordinate = CoOrdinates(-90,80)
    val submarineControlSystem = ControlSystemImpl()
    val submarine = Submarine()
    submarine.changeSpeed(25)
    submarine.detectEnemy(99.55)
    println(submarine.autoPilot)
}