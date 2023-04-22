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

//    val iterator = numberList.listIterator()
//    while (iterator.hasNext()) iterator.next()
//    while (iterator.hasPrevious()) {
//        println(iterator.previous())
//    }
//    val first = 0
//    val last = 10
//    val step = 1
//    for (int i = first;i <= last; i += step) {
//        // ...
//    }
//    val mutableiteraror = numberList.iterator()
//    println(numberList)
//    mutableiteraror.next()
//    mutableiteraror.next()
//    mutableiteraror.remove()
//    println(mutableiteraror)
//    println(numberList)

    val evenNumber = generateSequence(1) { it * 2 }
    println(evenNumber.take(200).toList())
    println(evenNumber.take(10).toList())

    val lessthan10 = generateSequence(1) { if(it < 10) it + 1 else it}
    println(lessthan10.take(15).toList())
    
    val numberListChunk = sequence { 
        yield(5)
        yieldAll(listOf(8,10,12))
        yieldAll(generateSequence(20) { it + 1 })
        
    }
    println(numberListChunk.take(20).toList())

    val strL = "My Name is Darshan Dangar My Native place is Rajkot".split(" ")
    val sqstr = strL.asSequence()
    val lsqstr = sqstr.filter { println(it); it.length > 5 }
        .map { println("${it.length}"); it.length }
        .take(3)
    println(lsqstr.toList())

    println(numberSet.filter { it > 5; }
        .map { println(it); it }
        .take(3)
        )

    val numbers = listOf("one", "two", "three", "four")
    val filterResults = mutableListOf<String>()  //destination object
    numbers.filterTo(filterResults) { it.length > 3 }
    numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
    println(filterResults) // contains results of both operations

    // map

    val numMap = listOf(10, 11, 12, 21, 25, 28, 29, 24, 35)
    println(numMap.map { it })
    println(numMap.map { it * it })
    println(numMap.map { it / it })
    println(numMap.map { it - 10 })
    println(numMap.map { it.times(3) })
    println(numMap.map { it.downTo(1) }) //meaning
    println(numMap.mapIndexed { index, i -> index * 2 })

    //zip

    val animalList = listOf("Lion", "Horse", "Dog")
    val animalColor = listOf("Orange", "White", "Red")
    val resAnimal = animalList zip animalColor
    val resoAnimal = animalList.zip(animalColor)
    println()
    println(resAnimal)
    println(resoAnimal)
    println(animalList.zip(animalColor) {animalList, animalColor -> "$animalList color is: $animalColor"})

    val table = listOf("Darshan" to 1, "Shyam" to 2, "Shubham" to 3)
    println(table.unzip())

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



