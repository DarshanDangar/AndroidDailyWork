package com.example.kotlinpracticeandroid

sealed interface Shape {
    fun type()
    fun area()
}

object ShapeImpl : Shape {
    override fun area() {
        println("area is called")
    }

    override fun type() {
        println("type is called")
    }
}

sealed class Shapes(val shape: Shape) : Shape by shape

val shapeImpl = ShapeImpl

class Square2 : Shapes(shapeImpl)

fun main() {
    val square = Square2()
    square.shape.type()
}