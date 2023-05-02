package com.example.kotlinpracticeandroid.submarine

class Captain {

    fun fillFuelInSubmarine(fuelType: FuelSystem) {
        println("Fuel Added")
        println("Submarine Fuel type is: ${fuelType.fuelType} and it's Capacity is: ${fuelType.capacity}")
    }

}
