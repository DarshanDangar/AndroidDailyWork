package com.example.kotlinpracticeandroid



class Health(val name: String, var isWell: Boolean) {
    //var isHealthy = isHealth
    fun isWell() {
        if (!isWell) {
            println("$name is not fine")
            return
        }
        println("$name is fine")
    }

    var fever: Boolean = false
//    val fever: Boolean by Delegates.observable(false) {
//            _, oldValue, newValue ->  if (newValue) println("person has fever") else println("person is healthy")
//    }
}

fun Health.type() {
    println("Extension function use")

    fun isFever() {
        if (fever) println("Please take rest and take Azithromicine, paracitamol") else println("Don't worry")
    }
}

//open class Cart
//class Convertible: Cart()
//
//// defining the getType() extensions function on Car
//fun Cart.getType() = "Generic car"
//// defining the getType() extensions function on Convertible
////fun Convertible.getType() = "Convertible car"

open class BaseClass

class Derivedclass : BaseClass() {
    var classDe: String = ""
}

fun BaseClass.isReady() {
    println("Base class extension function use")
}

fun Derivedclass.isReady() {
    println("Derived class extension function use")
}

fun Any?.toString(): String {
    if (this == null) {
        return ""
    }
    return toString()
}

fun String.chara(): Char {
    return this[5]
}

interface ExtensionFunction {
    fun uses()
}

fun ExtensionFunction.randon() {
    fun uses() {
        println("Interface extension function use")
    }
}

class UseInterfaceExtension : ExtensionFunction {
    override fun uses() {

    }
}

class UseCompanionObj {
    companion object Name {

    }
}

fun UseCompanionObj.Name.add() {
    println("Name is Darshan")
}

class ExtOne {
    fun extOne() {
        println("ExtOne uses")
    }

    class ExtTwo {
        fun ExtOne.extTwo() {
            println("Ext two use in extone extension")
        }
    }
}

fun main() {

    val extOne = ExtOne.ExtTwo()

    println("Darshan".chara())
    val useCompobj = UseCompanionObj.add()

    val ans = 89658656.toString()
    println(ans)
    val derived = Derivedclass().isReady()
    println(derived)

    val health = Health("Darshan", true)
    health.isWell()
    health.type()

//    var convertible = Convertible()
//    convertible.getType()
}