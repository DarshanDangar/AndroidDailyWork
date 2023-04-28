package com.example.kotlinpracticeandroid.submarine

import kotlin.properties.Delegates

object FuelSystem { //

    const val fuelType: String = "Uranium"

    const val capacity: Int = 20000

    var fuelMeter: Int by Delegates.observable(5) { _, _, newValue ->
        if (newValue < 2) {
            SubmarineController().notifyOfFuelLevelIsLow() //
        }
    }

    fun fuelDetailNotification(message: String) {
        //println(message)
        if (message == "Fuel level is low please add fuel") { //
            Captain.fillFuelInSubmarine(FuelSystem)
        }
    }

}