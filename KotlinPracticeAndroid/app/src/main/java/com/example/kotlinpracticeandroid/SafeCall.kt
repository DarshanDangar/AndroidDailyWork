package com.example.kotlinpracticeandroid

data class Darshan(
    var brain: Brain? = null,
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

data class Brain(
    val reallyHasBrain: Boolean = true,
    var cells: List<Cell> = emptyList()
)

fun main() {
    val darshanTheRockStar = Darshan(hasCommonSense = false)

    val cellCount = darshanTheRockStar
        .brain
        ?.cells
        ?.size
        ?.let {
            println(it)
            it
        } ?: 0

    println(cellCount)

    val brain = Brain(true, listOf(Cell(50), Cell(10)))
    val legs = Legs(2)
    val hands = Hands(2)

    val darshan = Darshan(brain, legs, hands, true)
    val darshanBrainCellCount = darshan
        .brain
        ?.cells
        ?.size
        .let {
            println(it)
            it
        }
    println(darshanBrainCellCount)

    val darshanHandsCount = darshan
        .hands
        ?.count
        .let {
            println(it)
            it
        }
    println(darshanHandsCount)

    val darshanLegCount = darshan
        .legs
        ?.count
        .run {
            println(this)
            this
        }
    println(darshanLegCount)

    val darshanRockStar = Darshan(brain, hasCommonSense = true)

    val darshanRockStarLegsCount = darshanRockStar
        .legs
        ?.count
        .let {
            if (it == null) 0
            else
                it
        }
    println(darshanRockStarLegsCount)

    val darshanRockStarHandsCount = darshanRockStar
        .hands
        ?.count
        .let {
            when (it) {
                null -> 0
                else -> it
            }
        }
    println(darshanRockStarHandsCount)

    val darshanRockStarBrainCellCount = darshanRockStar
        .brain
        ?.cells
        ?.size
        .let {
            if (it != null) it else 0
        }
    println(darshanRockStarBrainCellCount)

    val DarshanRockStarHasCommonsense = darshanRockStar
        .hasCommonSense
        .let {
            println(it)
            it
        }
    println(DarshanRockStarHasCommonsense)

     val darshanTheRockStarUseElvisOp = darshanTheRockStar
        .hands
        ?.count
        .let {
            it ?: 0
        }
    println(darshanTheRockStarUseElvisOp)

    val darshanTheRockStarHandsCountuseOrEmpty = darshanTheRockStar
        .brain
        ?.cells
        .orEmpty()
        .size
        .let {
            println(it)
            it
        }
    println(darshanTheRockStarHandsCountuseOrEmpty)

//    darshanTheRockStar
//        .brain
////        .apply {
////            this?.cells = brain
////        }
//        ?.cells
//        ?.size
//        .let {
//            println(it)
//        }

//  darshanTheRockStar
//        .brain
//        ?.cells
//        ?.filter {
//            val cellIdgratethanten = (it.id > 10)
//            cellIdgratethanten
//        }
//        ?.let {
//            println(it)
//        } ?: println(0)
//
//    darshan
//        .brain
//        ?.cells
//        ?.map {
//            val cellsMap = it.id * 2
//            println(cellsMap)
//            cellsMap
//        }
//        .let {
//            println(it)
//        }
//
//    darshanTheRockStar
//        .brain
//        ?.cells
//        ?.mapNotNull {
//            if ()
//        }

}
