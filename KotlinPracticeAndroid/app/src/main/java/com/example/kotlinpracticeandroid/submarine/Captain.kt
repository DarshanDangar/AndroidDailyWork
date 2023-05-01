package com.example.kotlinpracticeandroid.submarine

class Captain {

    lateinit var submarine: SubmarineController
    fun changeSpeedOfSubmarin(speed: Int) {
        submarine.submarineSpeed += speed
    }

    fun fillFuelInSubmarine(fuelType: FuelSystem) {
        println("Fuel Added")
        println("Submarine Fuel type is: ${fuelType.fuelType} and it's Capacity is: ${fuelType.capacity}")
    }

    val attackOnEnemy = {
        submarine.hasLaunchMissile = true
        println("Missile is Launch: ${submarine.hasLaunchMissile}")
            if (submarine.missileCount == 0) {
                println("Missile is Empty, please help")
                submarine.notifyForMissileHelp("Missile is empty, please Help")
            }
    }
}
