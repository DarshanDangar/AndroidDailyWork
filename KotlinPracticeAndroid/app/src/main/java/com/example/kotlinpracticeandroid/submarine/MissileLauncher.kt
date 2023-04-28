package com.example.kotlinpracticeandroid.submarine

import kotlin.properties.Delegates

object MissileLauncher {

    //var missileCount = Missile().missileCount

    var launchMissile: Boolean by Delegates.observable(false) { _, _, _ ->
        if (launchMissile) Missile().missileCount -= 1
    }

}
