package com.example.kotlinpracticeandroid.submarine

import kotlin.properties.Delegates

open class MissileLauncher {

    init {
        println("Missile Launching...")
    }

    var missileCount: Int by Delegates.observable(2) { _, old, new ->
        println("Old missile count is: $old and new Missile Count is: $new")
        SubmarineController.numbersOfMissileInSubmarine = new
    }

    var hasLaunchMissile: Boolean by Delegates.observable(false) { _, _, _ ->
        if (hasLaunchMissile) missileCount - 1
    }

}
