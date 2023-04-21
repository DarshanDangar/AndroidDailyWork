package com.example.kotlinpracticeandroid

val numberList = mutableListOf(5, "Darshan", 5.0, 6, 8, 9, 10, 5)

val numberSet = setOf(5, 4, 8, 9, 10, 12, 14, 5, 2)

val deatilsPersonMap = mapOf("Darshan" to 21, "Shyam" to 21.2, "Shubham" to 20, "Sagar" to 21.5, "Rajan" to 21.3, "Priyanshu" to 21.4,
25 to 21)

val numBuilder = buildMap {
    put("CSE", 1)
    put("Mec", 2)
    put("Aut", 3)
}

val setBuilder = buildSet<Int> {
    add(5)
    add(6)
}

val listBuilder = buildList<Int> {
    add(10)
    add(12)
    add(15)
}

// empty

val emptyList = emptyList<Int>()

val emptySet = emptySet<Any>()

val emptyMap = emptyMap<Int, String>()

val initLists = List(10, {it * 3})


fun main() {
//    println(initLists)
//    println(numBuilder)
//    println(setBuilder)
//    println(listBuilder)

//    numberList.forEach {
//        println(it)
//    }

    val iterator = numberList.listIterator()
    while (iterator.hasPrevious()) {
        println(iterator.previous())
    }

//    for (ele in collection){
//        println(ele)
//    }
//    println(numberList.take(5))
//    println(numberList.get(4))
//    println(numberList)
//    println(numberList.lastIndexOf(8))
//    println(numberList.last())
//    //println(collection.listIterator(5)) //list
//    println(numberList.size)
//    println(numberList.containsAll(listOf(15)))
//    println(numberList.isEmpty())
//    println(numberList.asReversed())
//    println(numberList.component1())
//    println(numberList.dropLast(2))
//    println(numberList.lastIndexOf(6))
//    println(numberList.takeLast(1))
//    println(numberList.indexOf(6))
//    println(numberList.indexOf("Darshan"))
//    println(numberList.count())
//    println(numberList.removeAt(2))
//    println(numberList.shuffle())
//    println(numberList)
//    println(numberList.indices)
//    println(numberList.minus(5))
//    println(numberList.plus(50))
//    println(numberList)
//    println(numberList.takeLast(3))
//    //collection.add(8, 10 as Nothing)
//
//    numberSet.size
//    println()
//    println(numberSet.take(5))
//    println(numberSet)
//    println(numberSet.size)
//    println(numberSet.isEmpty())
//    println(numberSet.containsAll(listOf(5)))
//    println(numberSet.contains(5))
//    println(numberSet.indices)
//    println(numberSet.parallelStream()) // meaning
//    println(numberSet.spliterator()) // meaning split with iterator
//    println(numberSet.minus(2))
//    println(numberSet)
//    println(numberSet.stream()) // meaning
//    println(numberSet.min())
//    println(numberSet.plus(20))
//    println(numberSet.average())
//    println(numberSet.distinct()) // meaning
//    println(numberSet.any())
//    println(numberSet.max())
//    println(numberSet.last())
//    println(numberSet.first())
//    println(numberSet.first())
//    println(numberSet.last())
//    println(numberSet.none())
//    println(numberSet)
    //    println(deatilsPersonMap.keys)
//    println(deatilsPersonMap.values)
//    println(deatilsPersonMap.keys)
//    println(deatilsPersonMap.values)
//    println(deatilsPersonMap.keys)
//    println(deatilsPersonMap.values)
//    println(deatilsPersonMap.size)
//    println(deatilsPersonMap.containsValue(20))
//    //println(deatilsPersonMap.toList())
//    println(deatilsPersonMap[1])
//    println(deatilsPersonMap.get("Darshan"))
//    println(deatilsPersonMap["Darshan"])
//    println(deatilsPersonMap)
//
//    for (i in deatilsPersonMap.keys) {
//        println(i)
//    }
//
//    for (i in deatilsPersonMap.values) {
//        println(i)
//    }
//
//    for (i in deatilsPersonMap) {
//        println(i)
//    }

}



