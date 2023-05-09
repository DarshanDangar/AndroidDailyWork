package com.example.kotlinpracticeandroid

class Employee {

    var empId: Int = 0
    val department: Department? = null

}

class Department {
    val deptName: String = "Native Mobile"
}

class Calculator(private val num: Int) {
    fun square() {
        println(num * num)
    }

    inner class Addition(private val num1: Int, private val num2: Int) {
        fun add() {
            println(num1 + num2)
        }
    }

}

val listOfString = listOf("Darshan", null, "Sagar", null, "Rajan", "Priyanshu", null)
var newStringListWithoutNull = listOf<String?>()

fun main() {
    for (element in listOfString) {
        element?.let {
            newStringListWithoutNull = newStringListWithoutNull.plus(element)
        }
    }
    println(newStringListWithoutNull)
    val square = Calculator(5)
    square.square()
    val employee = Employee()
    val resultOfEmployee = employee.department?.deptName
    val useElvisOperator = resultOfEmployee?.length ?: -1
    println(useElvisOperator)
    //val isDeveloper = emp?.department?.deptName
    println(resultOfEmployee)
    val name: String?
    name = null
    val useElvisOP = name?.length ?: -1
    println(useElvisOP)
    var age = 21
    //age = null
    val address: String? = null

    val result = name?.length ?: -1

//    if (name != null && name.length > 0) {
//        println("Name is: $name and its length is ${name.length}")
//    } else {
//        println("String is empty")
//    }

    println(name?.length)
    println(address?.length)

    val darshan = 5.0

    val darshanAge: Int? = darshan as? Int
    println(darshanAge)

    val checkEqualityObj = "Darshan"
    val checkEqualityobj = "Darshan"

    if (checkEqualityobj === checkEqualityobj) {
        println("both are same")
    }

    if (checkEqualityobj == checkEqualityobj) {
        println("both are same")
    }

    val emp = Employee()
    val dept = emp
    emp.empId = 0

    if (emp === dept) {
        println("emp and dept both reference are same")
    } else {
        println("emp and dept are not same reference")
    }
}