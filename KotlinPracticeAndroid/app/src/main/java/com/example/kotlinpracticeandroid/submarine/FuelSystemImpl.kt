package com.example.kotlinpracticeandroid.submarine

class FuelSystemImpl : FuelSystem {

    override val fuelType: String = "Uranium"

    override val capacity: Int = 20_000

    override var fuelMeter: Int = 5

    override fun onReceiveDistance(distance: Int) {

        fuelMeter = when (distance) {
            in 0..20 -> fuelMeter - 0
            in 21..40 -> fuelMeter - 1
            in 41..60 -> fuelMeter - 2
            in 61..80 -> fuelMeter - 3
            in 81..100 -> fuelMeter - 4
            else -> 0
        }

        println("Fuel level is: $fuelMeter")
        if (fuelMeter <= 2) {
            println("Fuel level is down...")
        }
    }

}