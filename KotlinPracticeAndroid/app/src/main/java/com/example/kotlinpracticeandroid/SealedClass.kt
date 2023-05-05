package com.example.kotlinpracticeandroid

sealed class Demo {

    class Res: Demo() {

        fun printRes() {
            println("Res class is called")
        }

    }

    class Test: Demo() {

        fun printTest() {
            println("Test class is called")
            val a = 5
            val b = 7
            val max = if (a > b) {
                print("Choose a")
                a
            } else {
                print("Choose b")
                b
            }
        }

    }

}

sealed class Factory(name: String) {
    var namee = name
}

class FoodFactory: Factory("Balaji Pvt.ltd")
class CottonFactory: Factory("MN Yearns")
class Gidc: Factory("Gidc gate no. 2")

var foodFactory = FoodFactory()
var cottonFactory = CottonFactory()
var gidc = Gidc()

sealed interface Body {
    fun isLive()
    fun isReal()
}

sealed class BodyPart: Body {
    override fun isLive() {
        println("yes it is live")
    }
}

class Xyz: BodyPart() {
    override fun isReal() {
        println("xyz method use via bodypart")
    }
}

class Head: BodyPart() {
    override fun isReal() {
        TODO("Not yet implemented")
    }
}

fun main() {

    val xyz = Xyz()
    xyz.isLive()
    xyz.isReal()

    val res = Demo.Res()
    res.printRes()
    val test = Demo.Test()
    test.printTest()

    when(res) {
        is Demo.Res -> println("When is used forResource")
    }

    var age = 55
    var result = when(age) {
      in 18..60->  println("You are eligible for voting")
      else -> {"You are not eligible for voting"}
    }
    println(result)



    fun factoryType(name: Factory) {
        when(name){
            is FoodFactory -> println("this is food factory ${foodFactory.namee}" )
            is CottonFactory -> println("this is coton factory")
            is Gidc -> println("This is gidc")
        }
    }

    //println(cotonFactory.namee)
    factoryType(foodFactory)
    factoryType(cottonFactory)
    factoryType(gidc)

}