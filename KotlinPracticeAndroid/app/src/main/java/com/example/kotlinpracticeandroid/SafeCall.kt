package com.example.kotlinpracticeandroid

data class Darshan(
    val brain: Brain? = null,
    val legs: Legs? = null,
    val hands: Hands? = null,
    val hasCommonSense: Boolean
)

data class Hands(
    val count: Int
)

data class Legs(
    val count: Int
)

data class Cell(
    val id: Int
)

val listCell = Cell(5)

data class Brain(
    val reallyHasBrain: Boolean = true,
    val cells: List<Cell> = listOf(listCell)
)

fun main() {
    val darshanTheRockStar = Darshan(hasCommonSense = false)
//  val id = Cell(5)
//  val bran = Brain(cells = listOf())
    val cellCount = darshanTheRockStar.brain?.cells?.size
    println(cellCount)
}
