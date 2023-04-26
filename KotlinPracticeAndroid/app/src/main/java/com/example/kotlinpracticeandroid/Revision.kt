package com.example.kotlinpracticeandroid

open class Human(var name: String, var age: Int) {
    init {
        println("Human class initialized")
    }

    constructor(name: String): this(name, age = 0)
    open fun isHome(): Boolean {
        return true
    }
}

class Home(val address: String, val type: String): Human("Darshan", 21) {

    override fun isHome(): Boolean {
        //return super.isHome()
        return true
    }
}

class SbiBank {
    companion object AccountNo {
        var balance: Double = 0.0
        var name: String = ""
        var locorNo: Long = 0
    }

    object Ifsc {
        var code: Long = 0
    }

    fun deatils() {
        println("Bank user name is: $name, bank balaance is: $balance")
    }
}

abstract class SystemCom {
    var name: String = "MacOs 14.2"
    var price: Double = 80000.0

    abstract fun system()
}

class Pc: SystemCom() {

    override fun system() {
        println("System processing")
    }
}

sealed interface Res {
    fun sealedInterface()
}

sealed class Response: Res {
    fun sealedClassuse() {
        println("sealed class uses")
    }

    override fun sealedInterface() {
        println("Sealed interface use")
        println("After comipation impl")
    }
}

class Api: Response()

class Ui: Response()

class Activity: Response()

fun checkStatus(status: Response) {
    when(status) {
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
    sbi.deatils()

    val personalComputer = Pc()
    println(personalComputer.name)
    println(personalComputer.price)
    personalComputer.system()

    if (personalComputer is Pc) {
        println("true")
    }

    val string: Any = "Dangar Darshan"
    val result = string as? String
    println(result)

    val numDigit: Double = 15.5
    val resInt = numDigit.toInt()
    println(resInt)

    val activity = Activity()
    checkStatus(activity)
    activity.sealedInterface()
    activity.sealedClassuse()
}