package com.example.kotlinpracticeandroid.submarine

class MissileLauncher {

    private var missileCount: Int = 10

    fun launchMissile(coordinate: Coordinate) {
        println("Missile Launching...this coordinates: ${coordinate.x} and ${coordinate.y}")
        missileCount -= 1
        println("missile count is: $missileCount")
        if (missileCount == 0) {
            println("Missile is Empty, please refill it")
        }
    }
}
