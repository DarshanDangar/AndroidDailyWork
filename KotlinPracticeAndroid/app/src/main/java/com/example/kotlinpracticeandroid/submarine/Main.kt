package com.example.kotlinpracticeandroid.submarine

fun main() {
    val missileLauncher = MissileLauncher()
    val submarineController = SubmarineController()
    val fuelSystem = FuelSystemImpl()
    val submarine = Submarine(Captain(), submarineController, fuelSystem, missileLauncher)
    submarine.startSubmarine()
}

