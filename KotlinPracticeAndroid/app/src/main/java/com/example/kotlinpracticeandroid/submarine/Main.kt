package com.example.kotlinpracticeandroid.submarine

fun main() {
    val missileLauncher = MissileLauncher()
    val submarine = Submarine(Captain(), SubmarineController(missileLauncher), FuelSystemImpl())
    submarine.startSubmarine()
}

