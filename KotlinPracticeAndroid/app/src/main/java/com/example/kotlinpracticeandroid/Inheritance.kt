package com.example.kotlinpracticeandroid

open class Animal(val name: String, val type: String, val life: Int, var color: String) {

    constructor(color: String): this(name = "Puppy", type = "Pet", life = 2, color = color)

    open fun isRiding() {
        println("this horse ride is awesome 45 km/h speed")
    }
}

open class Dog: Animal("Dog", "pet", 5, "White") {
    val nikName: String = "Tomy"
}

class Horse(name: String, type: String, life: Int, color: String): Animal(name,type,life,color) {

    constructor(color: String): this("Radhika", "Marwadi", 30, color) {
        this.color = color
        println("Sec called")
    }

    override fun isRiding() {
        super.isRiding()
    }

}

// class Horse: Animal {
//    constructor(color: String): this("Bavli", "Marwadi", 30, color) {
//        this.color = color
//        println("Sec called")
//    }
//    constructor(name: String, type: String, life: Int, color: String): super(name = name, type = "", life = 0, color = ""){
//    }
//
//}

// multilevel inheritance

class Puppy: Dog()

class CheckConstructor {
    val assign: Int
    constructor(assign: Int) {
        this.assign = assign
    }
}

open class Base {
    init {
        println("This is base class")
    }
}

open class Child: Base() {
    init {
        println("This is child class")
    }
}

class GrandChild: Child() {
    init {
        println("This is grand Child class")
    }
}


fun main() {

    val grandChild = GrandChild()


    val puppy = Puppy()
    println(puppy.name)
    println(puppy.type)
    println(puppy.color)
    println(puppy.life)
    println(puppy.nikName)

    val checkConstructor = CheckConstructor(5)
    println(checkConstructor.assign)


    val dog = Dog()
    println(dog.nikName)
    println(dog.type)

    val horse = Horse("Rozy", "Kathiyawadi", 25, "White")
    println(horse.name)
    println(horse.type)
    println(horse.color)
    val chetak = Horse("RedWhite")
    println(chetak.name)
    println(chetak.type)
    println(chetak.color)
    chetak.isRiding()

}