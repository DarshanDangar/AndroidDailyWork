package com.example.kotlinpracticeandroid

val pi = 3.14
val oneDouble = 5.0
val oneMilion = 1_00_000_0L

val isName = true
val isId = false

val charact = 'c'
val newCharact: Char = 'd'

fun typeCheck() {
    println(pi is Double)
    println(oneDouble is Double)
    println(numberLong is Long)
}

fun testType(digitDouble: Double) {
    println(digitDouble)
}

val numberLong = 5L

val str = "Darshan"

var array = IntArray(5) {it * 2}

fun main() {
//    typeCheck()
//    testType(5.0)
//    testType(8.0)
//    println(isName && isId)
//    println(isName || isId)
//    println(!isName)
//    println(charact)
//    println('\n')
//    for (i in str) {
//        println(i)
//    }
//    println(str.uppercase())
//    println(str)
//    println("String is: ${str.length}")
//    println()
    val person = Person("Darshan", 21)
    person.name()
    println(car.name)

    val deatils = Deatils()
    deatils.main()

}

class Person(name: String, age: Int) {
    var personName: String
    var personAge: Int
    init {
        personName = name
        personAge = age
        println("personName initialized and that is: $personName")
    }

    fun name(){
        println(personName)
        student.deatil()
    }

}

class Student(val studentId: Int = 0, val studentDepartment: String) {

    fun deatil() {
        println("Student id is: $studentId and student Department is: $studentDepartment")
    }
    constructor(studentDepartment: String) : this(0,studentDepartment) {
        println("newdepartment is: $studentDepartment")
    }
}

//var student = Student(studentDepartment = "yyu")
var student = Student(17,"Computer Engineering")
var studentMech = Student("Mechanical")

//var student = Student("Darshan")

class Vehicle(var name: String)

var car = Vehicle("Weganor")

// inheritance
// all class by default final so can't inherit therefore make open

open class Transport(var transportRoot: String, var transportName: String) {
    open fun price() {
        println("price depends on root, vehicle and iteam")
    }
}

class VehicleTransport(var price: Int, transportName: String, transportRoot: String) :
    Transport(transportRoot, transportName) {
    override fun price() {
        super.price()
        println("truck price is depend on iteam size and weight")
        println("price is: $price")
        println("Transport Name is: $transportName")
        println("Transport Root s: $transportRoot")
    }
}

class Bus(price: Int, transportRoot: String, transportName: String) : Transport(transportRoot, transportName) {

    var money = price

    override fun price() {
        println("bus price is fix on particular root")
    }
}

class Deatils {

    var truck = VehicleTransport(1000, "Dangar Logistics", "Rajkot - Ahmedabad")

    fun main() {
        truck.price()
    }
}




