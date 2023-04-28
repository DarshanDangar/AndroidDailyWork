package com.example.kotlinpracticeandroid

object Tv {

    fun printTv() {
        println("Object Tv called")
    }

}

object RefrigReator {

    fun printRef() {
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

    companion object {}

}


object checkObject

// sealed class inherit

sealed class FileAction

class Open : FileAction()

data class Close(val action: String) : FileAction()

fun checked(check: FileAction) {
    when (check) {
        is Open -> println("This is simople class")
        is Close -> println("This is data class")
    }
}

// companion object

class Companion {

    companion object C {
        private fun check() {
            println("called companion object")

        }

    }

    object Check {
        fun objCheck() {
            check()
            println("object called in class")
        }
    }

}

class TypeAliasChecked {
    var ghj = 55
}

typealias asd = TypeAliasChecked

fun main() {

    val dataClass = Close("Pending")
    checked(dataClass)

    println(checkObject)

    val anonymousObject = AnonymousObject()
    anonymousObject.getObject()

    var result = object : Brts {
        override fun root() {
            println("Brts bus root is Iscon-Cross road to Naroda")
        }

        override fun price() {
            println("Brts bus ticket is 25 rupees")
        }

        override fun isElectric() {
            println("Yes, This bus is electrick")
        }
    }

    result.root()
    result.isElectric()
    result.price()

    Tv.printTv()
    RefrigReator.printRef()

    var likes = object {

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