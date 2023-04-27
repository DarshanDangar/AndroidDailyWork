package com.example.kotlinpracticeandroid.submarine

interface ControlSystem {
    val autoPilot: Boolean
    var fuelMeter: Int
    fun detectEnemy(frequency: Double)
    fun changeSpeed(speed: Int)
    fun navigation(ordinate: CoOrdinates)
}