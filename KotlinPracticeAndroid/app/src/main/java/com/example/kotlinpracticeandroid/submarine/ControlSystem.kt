package com.example.kotlinpracticeandroid.submarine

interface ControlSystem {

    var autoPilot: Boolean

    fun detectEnemy(frequency: Int)

    fun currentLocation(ordinate: Coordinate)

}