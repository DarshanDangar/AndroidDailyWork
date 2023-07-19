package com.example.kotlinpracticeandroid.delegate

interface DatabaseService {
    fun setProgress(progress: Int) {
        println("Setting progress: $progress")
    }
}

val databaseService = object : DatabaseService {}

var progress: Int = 0
    set(value) {
        field = value
        databaseService.setProgress(value)
    }

fun main() {
    progress = 5
    progress = 10
    progress = 15
}