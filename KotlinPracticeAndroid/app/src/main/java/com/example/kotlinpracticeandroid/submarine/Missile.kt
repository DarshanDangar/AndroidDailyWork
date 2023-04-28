package com.example.kotlinpracticeandroid.submarine

import kotlin.properties.Delegates

class Missile {

    var missileCount: Int by Delegates.observable(2) { _, old, new ->
        println("Old missile count is: $old and new Missile Count is: $new")
        SubmarineController().numbersOfMissileInSubmarine = new
        if (new == 0) {
            SubmarineController().notifyForMissileHelp("Missile is Empty, Help us")
        }
    }

}