package com.example.kotlinpracticeandroid

class Health(val name: String, private var isWell: Boolean) {

    fun isWell() {
        if (!isWell) {
            println("$name is not fine")
            fever = true
            return
        } else {
            println("$name is fine")
        }
    }

    var fever: Boolean = false
}

fun Health.type() {
    fun isFever() {
        if (fever) println("Please take rest and take Azithromicine, paracetamol") else println("Don't worry you are Healthy")
    }
}

open class BaseClass

class DerivedClass : BaseClass() {
    var classDe: String = ""
}

fun BaseClass.isReady() {
    println("Base class extension function use")
}

fun Any?.toString(): String {
    if (this == null) {
        return ""
    }
    return this.toString()
}

fun String.chara(): Char {
    return this[5]
}

interface ExtensionFunction {
    fun uses()
}

fun ExtensionFunction.random() {
    fun uses() {
        println("Interface extension function use")
    }
}

class UseInterfaceExtension : ExtensionFunction {

    override fun uses() {
        println("uses method use")
    }

}

class UseCompanionObj {

    companion object Name

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
            println("Ext two use in extOne extension")
        }

    }

}

class AddString {

    val add: String = "Hello"

}

fun AddString.addString(str: String) {
    println("$add $str")
}

object Missile

fun Missile.launchMissile() {
    println("Missile Launching...")
}

fun main() {

    val missile = Missile
    missile.launchMissile()

    val stringConcatenation = AddString()
    stringConcatenation.addString("Darshan")

    val extOne = ExtOne.ExtTwo()
    println(extOne)

    println("Darshan".chara())
    val useCompObj = UseCompanionObj.add()
    println(useCompObj)

    val ans = 89658656.toString()
    println(ans)
    val derived = DerivedClass()
    derived.isReady()
    println(derived)

    val health = Health("Darshan", true)
    health.isWell()
    health.type()

}