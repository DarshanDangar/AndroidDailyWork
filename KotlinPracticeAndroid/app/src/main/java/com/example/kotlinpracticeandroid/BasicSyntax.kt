package com.example.kotlinpracticeandroid

const val pi = 3.14
val oneDouble = 5.0
val oneMillion = 1_00_000_0L

val isName = true
val isId = false

val character = 'c'
val newCharacter: Char = 'd'

fun testType(digitDouble: Double) {
    println(digitDouble)
}

val numberLong = 5L

val nameString = "Darshan"

var array = IntArray(5) { it * 2 }

class Person(name: String, age: Int) {

    private var personName: String
    private var personAge: Int

    init {
        personName = name
        personAge = age
        println("personName initialized and that is: $personName")
    }

    fun name() {
        println(personName)
        student.detail()
    }

}

class Student(private val studentId: Int = 0, private val studentDepartment: String) {

    fun detail() {
        println("Student id is: $studentId and student Department is: $studentDepartment")
    }

    constructor(studentDepartment: String) : this(0, studentDepartment) {
        println("newDepartment is: $studentDepartment")
    }

}

var student = Student(17, "Computer Engineering")
var studentMech = Student("Mechanical")

class Vehicle(var name: String)

var car = Vehicle("Weganor")

open class Transport(var transportRoot: String, var transportName: String) {
    open fun price() {
        println("price depends on root, vehicle and iteam")
    }
}

class VehicleTransport(private var price: Int, transportName: String, transportRoot: String) :
    Transport(transportRoot, transportName) {
    override fun price() {
        super.price()
        println("truck price is depend on iteam size and weight")
        println("price is: $price")
        println("Transport Name is: $transportName")
        println("Transport Root s: $transportRoot")
    }
}

class Bus(price: Int, transportRoot: String, transportName: String) :
    Transport(transportRoot, transportName) {

    var money = price

    override fun price() {
        println("bus price is fix on particular root")
    }
}

class Details {

    private var truck = VehicleTransport(1000, "Dangar Logistics", "Rajkot - Ahmedabad")

    fun main() {
        truck.price()
    }
}

fun main() {

    testType(5.0)
    testType(8.0)
    println(isName && isId)
    println(isName || isId)
    println(!isName)
    println(character)
    println('\n')
    for (element in nameString) {
        println(element)
    }
    println(nameString.uppercase())
    println(nameString)
    println("String is: ${nameString.length}")
    println()
    val person = Person("Darshan", 21)
    person.name()
    println(car.name)

    val details = Details()
    details.main()
    println(pi)
    println(oneDouble)
    println(numberLong)
    println(oneMillion)
    println(newCharacter)
    println(array)
    println(studentMech)

}




