package com.example.kotlinpracticeandroid.submarine

import kotlin.properties.Delegates

open class MissileLauncher {

    var missileCount: Int by Delegates.observable(2) { _, old, new ->
        println("Old missile count is: $old and new Missile Count is: $new")
    }

    var hasLaunchMissile: Boolean by Delegates.observable(false) { _, _, _ ->
        if (hasLaunchMissile) {
            println("Missile Launching...")
            missileCount -= 1
            println("missile count is: $missileCount")
            if (missileCount == 0) {
                println("Missile is Empty, please refill it")
            }
        }
    }

}
