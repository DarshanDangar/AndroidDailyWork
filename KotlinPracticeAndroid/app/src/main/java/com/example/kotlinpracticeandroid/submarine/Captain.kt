package com.example.kotlinpracticeandroid.submarine

object Captain : SubmarineController() { //
    fun changeSpeedOfSubmarin(speed: Int) {
        submarineSpeed += speed
    }

    fun fillFuelInSubmarine(fuelType: FuelSystem) {
        println("Fuel Added")
        println("Submarine Fuel type is: ${fuelType.fuelType} and it's Capacity is: ${fuelType.capacity}")
    }

    val attackOnEnemy = {
        MissileLauncher.launchMissile = true
        println("Missile is Launch: ${MissileLauncher.launchMissile}")
            if (Missile().missileCount == 0) {
                println("Missile is Empty, please help")
                SubmarineController().notifyForMissileHelp("Missile is empty, please Help")
            }
    }
}
