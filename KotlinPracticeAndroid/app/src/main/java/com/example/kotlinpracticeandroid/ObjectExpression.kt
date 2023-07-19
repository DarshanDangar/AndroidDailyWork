package com.example.kotlinpracticeandroid

object Tv {

    fun details() {
        println("This tv has 32 inches as screen size")
    }

}

object Refrigerator {

    fun details() {
        println("Object RefrigReator called")
    }

}

// Anonymous object

interface Brts {

    fun root()

    fun isElectric()

    fun price()

}

class AnonymousObject {
    fun getObject() = object {
        val obj: String = "Object"
    }

    companion object {
        var balance: Int = 0
    }

}

sealed class FileAction

class Open : FileAction()

data class Close(val action: String) : FileAction()

fun checked(check: FileAction) {
    when (check) {
        is Open -> println("This is simple class")
        is Close -> println("This is data class")
    }
}

class Companion {

    companion object Check {
        private fun check() {
            println("called companion object")

        }

    }

    object CheckObject {
        fun objCheck() {
            check()
            println("object called in class")
        }
    }

}

fun main() {

    val dataClass = Close("Pending")
    checked(dataClass)

    val anonymousObject = AnonymousObject()
    anonymousObject.getObject()

    val result = object : Brts {
        override fun root() {
            println("Brts bus root is Iscon-Cross road to Naroda")
        }

        override fun price() {
            println("Brts bus ticket is 25 rupees")
        }

        override fun isElectric() {
            println("Yes, This bus is electric")
        }
    }

    result.root()
    result.isElectric()
    result.price()

    Tv.details()
    Refrigerator.details()

    val likes = object {

        var fbLikes = 0
        var instaLikes = 0

        fun fbLikes() {
            println("Fblikes is added")
            fbLikes++
        }

        fun instaLikes() {
            println("Instagram likes added")
            instaLikes++
        }

    }

    println(likes.fbLikes)
    println(likes.fbLikes())
    println(likes.fbLikes)
    println(likes.instaLikes)
    println(likes.instaLikes())
    println(likes.instaLikes)

}