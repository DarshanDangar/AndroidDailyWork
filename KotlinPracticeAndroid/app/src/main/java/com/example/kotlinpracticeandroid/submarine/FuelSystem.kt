package com.example.kotlinpracticeandroid.submarine

interface FuelSystem {

    val fuelType: String

    val capacity: Int

    var fuelMeter: Int

    fun onReceiveDistance(distance: Int)

}

