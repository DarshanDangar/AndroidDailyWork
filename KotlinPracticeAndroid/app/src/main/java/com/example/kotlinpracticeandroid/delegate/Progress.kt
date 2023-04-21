package com.example.kotlinpracticeandroid.delegate

import kotlin.reflect.KProperty

class Progress(private val databaseService: DatabaseService) {

    private var progress = 0
        set(value) {
            field = value
            databaseService.setProgress(value)
        }

    operator fun getValue(thisRef: Any, property: KProperty<*>): Int = progress

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
        progress = value
    }
}

class Main {
    var progress by Progress(databaseService)

    fun main() {
        var progress = Main().progress
        progress = 5
        println(progress)
    }
}

fun main() {
    Main().main()
}





