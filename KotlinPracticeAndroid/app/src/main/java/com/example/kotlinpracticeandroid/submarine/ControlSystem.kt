package com.example.kotlinpracticeandroid.submarine

interface ControlSystem {

    var autoPilot: Boolean

    fun onReceiveFrequency(frequency: Int)

    fun navigateTo(cordinate: Coordinate)

    fun notifyDistanceInFuelSystem(distance: ((Int) -> Unit)?)

    fun setMissileLauncher(missileLaunch: ((coordinate: Coordinate) -> Unit))

}