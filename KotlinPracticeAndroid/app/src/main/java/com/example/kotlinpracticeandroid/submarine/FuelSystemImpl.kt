package com.example.kotlinpracticeandroid.submarine

import kotlin.properties.Delegates

class FuelSystemImpl: FuelSystem {

    override val fuelType: String = "Uranium"

    override val capacity: Int = 20_000

    override var fuelMeter: Int by Delegates.observable(5) { _, _, newValue ->
        if (newValue < 2) {
            //notifyOfFuelLevelIsLow() //
        }
    }
}