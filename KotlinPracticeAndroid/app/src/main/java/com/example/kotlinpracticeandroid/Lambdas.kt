package com.example.kotlinpracticeandroid

// Higher order function

fun person(greeting: () -> Unit) {
    greeting()
}

fun name() {
    println("Suspend function use")
}

data class DeatilsofPerson(val name: String, var age: Int)

// reference function (callable func)

fun isodd(x: Int) = x % 2 != 0

fun compare(a: String, b: String) = a.length < b.length



fun main() {
//    println(compare("Drshan", "DangarDar"))
      val arr = arrayOf(5,4,6,2,1,0,10,8,7,9)
//    println(arr.filter(::isodd))
//    println(isodd(5))
//    println(::isodd)
//
//    val sum: (Int, Int) -> Int = {a: Int, b: Int -> a + b}
//    println(sum(5,6))
//
//    val greeting = {println("Hello Darshan")}
//    greeting()
//    val product = {a: Int, b: Int -> a * b }
//    val lam = {a: Int,b: Int -> a * b}
//    println(lam(5,6))
//    val productResult = product(5, 4)
//    println(productResult)
//    person({println("Good Morning")})
//
//    var people = listOf(
//                DeatilsofPerson("Darshan", 21),
//                DeatilsofPerson("Shyam",20),
//                DeatilsofPerson("Shubham", 22),
//                DeatilsofPerson("Rajan", 21),
//                DeatilsofPerson("Sagar", 22)
//    )
//
//    val resultmaxAge = people
//        .filter { it.name.startsWith('S') }
//        .maxBy({ it.age })
//    println(resultmaxAge)
//    println(resultmaxAge.age)
//    println(resultmaxAge.name)

    println(arr.filter { it > 5 })
   val anonymous = fun(x: Int, y: Int): Int {
        return x + y
    }
    val anonyresult = anonymous(8,10)
    println(anonymous)

    val sum2  = { a: Int , b: Int -> a + b}

    var stringExp = "gonna do "
    val addS = fun String.(successor: String) : String {
        return this + successor
    }
    stringExp = stringExp . addS ("nothing much.")
    println (stringExp)


}