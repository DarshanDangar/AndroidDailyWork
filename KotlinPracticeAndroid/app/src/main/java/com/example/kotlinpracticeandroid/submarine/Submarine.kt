package com.example.kotlinpracticeandroid.submarine

class Submarine(captain: Captain, submarineController: SubmarineController, fuelSystem: FuelSystemImpl, missileLauncher: MissileLauncher)  //
fun main() {
    val submarine = Submarine(Captain(), SubmarineController(), FuelSystemImpl(), MissileLauncher())
}
