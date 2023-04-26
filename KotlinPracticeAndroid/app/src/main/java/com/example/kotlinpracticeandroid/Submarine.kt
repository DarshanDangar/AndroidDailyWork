package com.example.kotlinpracticeandroid

interface ControlSystem {
    val autoPilot: Boolean
    fun detectEnemy(frequency: Double)
    fun changeSpeed(speed: Int)
    fun navigation(ordinate: Ordinates)
}

data class Ordinates(val x: Float, val y: Float) // 3

class Submarine(
    val inventationDate: String, // 4
    val depthCapacity: Double,
    val typesSubmarine: String,
    val officersCapacity: Int //5
    ): ControlSystem { //7

    private var speedOfSubmarine = 0 // 6
    //lateinit var direction: Direction
    lateinit var ordinateOfSubmarine: Ordinates //8 (current location)

    override var autoPilot: Boolean = true //12

    override fun detectEnemy(frequency: Double) {
        if (frequency > 500) { //10
            changeSpeed(-10)
            Missile.launchMissile = false
        }

        if (frequency < 200) {
            attackAlarm() //11
            attackOnEnemy()
            autoPilot = false
        }
    }


    override fun changeSpeed(speed: Int) { //13
        speedOfSubmarine += speed
    }

    override fun navigation(ordinate: Ordinates) { //14
        ordinateOfSubmarine = Ordinates(ordinate.x, ordinate.y)
    }

    private fun attackOnEnemy() { //15
        Missile.launchMissile = true
        println("Missile is Launch: ${Missile.launchMissile}")
    }

    private fun attackAlarm() {
        println("Enemy is near about us")
    }

//    fun direction(): String {
//        if (ordinateOfSubmarine.x >= 0  || ordinateOfSubmarine.y >= 0 && ordinateOfSubmarine.y <= 90) {
//            return "North"
//        } else if (ordinateOfSubmarine.x >= 91 && ordinateOfSubmarine.x <= 180 || ordinateOfSubmarine.y >= 91 && ordinateOfSubmarine.y <= 180) {
//            return "West"
//        } else if (ordinateOfSubmarine.x >= 181 && ordinateOfSubmarine.x <= 270 || ordinateOfSubmarine.y >= 181 && ordinateOfSubmarine.y <= 270) {
//            return "South"
//        } else {
//            return "East"
//        }
//    }
}

object Missile {
    var launchMissile: Boolean = false //16
}

fun main() {
    val ordinate = Ordinates(250f,250f)
    val submarine = Submarine("25/02/1990", 200.05, "cruise missile submarine", 20)
    //submarine.direction = Direction.South //18
    submarine.ordinateOfSubmarine = ordinate
    submarine.changeSpeed(25)
    submarine.detectEnemy(99.55)
    println(submarine.autoPilot)
}
