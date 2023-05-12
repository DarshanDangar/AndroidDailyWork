package com.example.kotlinpracticeandroid

open class Human(var name: String, var age: Int) {

    init {
        println("Human class initialized")
    }

    constructor(name: String) : this(name, age = 0)

    open fun isHome(): Boolean {
        return true
    }

}

class Home(val address: String, val type: String) : Human("Darshan", 21) {

    override fun isHome(): Boolean {
        //return super.isHome()
        return true
    }

}

class SbiBank {

    companion object AccountNo {
        var balance = 0.0
        var name = ""
        var locorNo = 0
    }

    object Ifsc {
        var code: Long = 0
    }

    fun details() {
        println("Bank user name is: $name, bank balance is: $balance")
    }
}

abstract class SystemDetails {
    var name: String = "MacOs 14.2"
    var price: Double = 80000.0

    abstract fun system()
}

class Pc : SystemDetails() {

    override fun system() {
        println("System processing")
    }
}

sealed interface Res {
    fun sealedInterface()
}

sealed class Response : Res {
    fun sealedClassUse() {
        println("sealed class uses")
    }

    override fun sealedInterface() {
        println("Sealed interface use")
        println("After compilation impl")
    }
}

object Api : Response()

object Ui : Response()

object Activity : Response()

fun checkStatus(status: Response) {
    when (status) {
        is Api -> println("Api is running")
        is Ui -> println("Ui is running")
        is Activity -> println("Activity is running")
    }
}

fun main() {
    val human = Human("Darshan")
    println(human.name)
    println(human.age)
    val men = Home("Ahmedabad", "Raw House")
    val res = men.isHome()
    println(res)

    val sbi = SbiBank()
    SbiBank.name = "Darshan Dangar"
    SbiBank.balance = 10000.0
    SbiBank.locorNo = 17
    sbi.details()

    val personalComputer = Pc()
    println(personalComputer.name)
    println(personalComputer.price)
    personalComputer.system()

    val string: Any = "Dangar Darshan"
    val result = string as? String
    println(result)

    val numDigit = 15.5
    val resInt = numDigit.toInt()
    println(resInt)

    val activity = Activity
    checkStatus(activity)
    activity.sealedInterface()
    activity.sealedClassUse()
}