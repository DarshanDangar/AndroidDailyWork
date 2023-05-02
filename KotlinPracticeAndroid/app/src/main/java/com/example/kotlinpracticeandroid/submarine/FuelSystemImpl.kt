package com.example.kotlinpracticeandroid.submarine

class FuelSystemImpl : FuelSystem {

    override val fuelType: String = "Uranium"

    override val capacity: Int = 20_000

//    override var fuelMeter: Int by Delegates.observable(5) { _, _, newValue ->
//        changeFuelMeter()
//        println("new fuel meter value is: $newValue")
//    }

    override var fuelMeter: Int = 5

    fun updateFuelMeter() {
        lateinit var submarineController: SubmarineController
        //lateinit var captain: Captain
//        fuelMeter = when (submarineController) {
//            in 0..20 -> 5
//            in 21..40 -> 4
//            in 41..60 -> 3
//            in 61..80 -> 2
//            in 81..100 -> 1
//            else -> 0
//        }

//        if (fuelMeter < 3) {
//            println("Fuel level is down")
//            submarineController.notifyOfFuelLevelIsLow(captain, this)
//        }
    }
}