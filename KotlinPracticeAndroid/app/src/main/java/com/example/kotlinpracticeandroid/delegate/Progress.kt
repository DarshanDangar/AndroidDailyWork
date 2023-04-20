package com.example.kotlinpracticeandroid.delegate

import kotlin.reflect.KProperty

class Progress(private val databaseService: DatabaseService) {

    private var progress = 0
        set(value) {
            field = value
            databaseService.setProgress(value)
        }

    operator fun getValue(thisRef: Main, property: KProperty<*>): Int = progress

    operator fun setValue(thisRef: Main, property: KProperty<*>, value: Any?) {
        if (value is Int)
            progress = value
    }

}

class Main {
    var progress by Progress(databaseService)
}

fun main() {
    var progress = Main().progress
    println(progress)
}

