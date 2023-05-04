package com.example.kotlinpracticeandroid.submarine

interface ControlSystem {

    var autoPilot: Boolean

    fun onReceiveFrequency(frequency: Int)

    fun navigateTo(ordinate: Coordinate)

    fun notifyDistanceInFuelSystem(distance: ((Int) -> Unit)?)

    fun setMissileLauncher(missileLaunch: (() -> Unit))

}