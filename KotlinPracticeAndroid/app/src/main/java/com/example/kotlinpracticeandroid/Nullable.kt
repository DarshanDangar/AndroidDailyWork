package com.example.kotlinpracticeandroid

class Employee {

   var empId: Int = 0
   val department: Department? = Department()

}

class Department {
   val deptName: String = "Native Mobile"
}

// Elvis operator

// this expression

class Calculator(val num: Int) {
   fun square() {
      println(num * num)
   }

   inner class Addition(val num1: Int, val num2: Int) {
      fun add() {
         println(num1 + num2)
      }
   }


}


fun main() {

   val square = Calculator(5)
   square.square()

//   val emp: Employee? = Employee()
//   val resu = emp?.department?.deptName
//   val useElvisop = resu?.length ?: -1
//   println(useElvisop)
//   //val isDeveloper = emp?.department?.deptName
//   println(resu)
//   var name: String? = "Darshan"
//   name = null
//   val useElvisOP = name?.length ?: -1
//   println(useElvisOP)
//   //println(name.length)
//   var age: Int = 21
//   //age = null
//   var address: String? = null
//
//   val result = if(name != null) name.length else -1
//
//   if (name != null && name.length > 0){
//      println("Name is: $name and its length is ${name.length}")
//   } else {
//      println("String is empty")
//   }
//
//   println(name?.length)
//   println(address?.length)

   val darshan: Double = 5.0
   //val len = darshan!!.length
   //println(len)

   val darshanAge: Int? = darshan as? Int
   println(darshanAge)

   val checkEqualityobj = "Darshan"
   val checkEqualityObj = "Darshan"

   if (checkEqualityobj === checkEqualityObj) {
      println("both are same")
   }

   if (checkEqualityobj.equals(checkEqualityObj)) {
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