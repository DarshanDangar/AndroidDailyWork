package com.example.kotlinpracticeandroid.submarine

import kotlin.properties.Delegates

class SubmarineController : ControlSystem {

    private val listOfFakeFrequency = listOf(505, 800, 100, 300, 900)

    private val notifyDistance: ((Int) -> Unit)? = null

    private lateinit var missileLauncher: (() -> Unit)

    private var submarineSpeed: Int = 25 //remove observable
        set(value) {
            when {
                value < 0 -> {
                    field = 0
                    println("old speed is: $value and New value is: $field")
                }
                value > 0 -> {
                    println("old speed is: $value and New value is: $field")
                }
            }
            field = value
        }

    private var coveredDistance = 0

    private var nextNavigateTo: Coordinate by Delegates.observable(
        Coordinate(
            0,
            0,
        )
    ) { _, old, new ->
        println("Notify successfully this $new")
        coveredDistance = (new.x - old.x) + (new.y - old.y)
        notifyDistance?.invoke(coveredDistance)
    }

    override var autoPilot: Boolean = false

    private fun changeSpeedOfSubmarin(speed: Int) {
        submarineSpeed += speed
    }

    override fun onReceiveFrequency(frequency: Int) {
        when (frequency) {
            in 200..500 -> {
                changeSpeedOfSubmarin(-10)
                missileLauncher()
            }
            in 0..200 -> {
                detectEnemy()
            }
        }
    }

    private fun detectEnemy() {
        notifyOfAttack()
        attackOnEnemy()
        autoPilot = false
        changeSpeedOfSubmarin(10)
        missileLauncher()
    }

    private fun notifyOfAttack() { // na
        println("Enemy is near us") //
    }

    override fun navigateTo(ordinate: Coordinate) {
        nextNavigateTo = ordinate
        onReceiveFrequency(listOfFakeFrequency.random())
    }

    private fun attackOnEnemy() {
        missileLauncher()
        //println("Missile is Launch: ${missileLauncher.hasLaunchMissile}")
    }

    override fun notifyDistanceInFuelSystem(distance: ((Int) -> Unit)?) {
        distance?.invoke(coveredDistance)
    }

    override fun setMissileLauncher(launcher: () -> Unit) {
        missileLauncher = launcher
    }

}
