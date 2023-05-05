package com.example.kotlinpracticeandroid

sealed interface Shape {
    fun type()
    fun area()
}

class ShapeImpl: Shape {
    override fun area() {
        println("area is called")
    }

    override fun type() {
        println("type is called")
    }
}

sealed class Shapeis(val shape: Shape): Shape by shape

val shapeimpl = ShapeImpl()

class Square2: Shapeis(shapeimpl) {

}

fun main() {
    val square = Square2()
    square.shape.type()
}