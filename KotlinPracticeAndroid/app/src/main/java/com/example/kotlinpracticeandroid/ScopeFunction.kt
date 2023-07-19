package com.example.kotlinpracticeandroid

var address: List<String?>? = listOf()

data class Member(var name: String, var age: Int, var address: String) {
    fun add() {
        println("Member name is: $name, age is: $age, address is: $address")
    }
}

class DataInDatabase(var name: String, var size: Int) {
    fun detail() {
        println("Details")
    }
}

class DepartmentOf(val name: String, private val work: String?) {
    fun data() {
        println("$name $work")
    }
}

fun main() {
    val nameOfPerson = "Darshan"

    nameOfPerson.map {
        println(it)
    }

    val numArr = arrayOf(5, 10, 15, 21, 25, 1, 2, 3, 8)
    numArr.map {
        it > 10
        println(it)
    }

    val nameList = listOf("Darshan", "Shyam", "Shubham", "Ram", "Raj", "Om")
    nameList.filter { it.length > 3 }
        .also { println(it) }
    println(nameList.first().uppercase())
    val nameL = nameList.map {
        //val x = it.first().lowercase()
        it.replace(it.first().toString(), it.first().lowercase())
        //it.lowercase()
    }
    println(nameL)

//    nameOfPerson.let {
//        println("Length of String using let: ${it.length}, $it!!")
//    }
//    println(nameOfPerson)
//
//    val name = Person("Darshan", 21).apply {
//        personAge = 20
//    }
//    println(name.personName)
//    println(name.personAge)

    val airportName = listOf("Rajkot", "London", "Dubai", "Ahmedabad", "Mumbai")
    with(airportName) {
        println("All airport name is: $airportName")
        println("number of airport is: $size")
        println("Sorted airport name is: ${airportName.sorted()}")
    }
    println(airportName)

    address?.let {
        //println(it.dropLast(2))
        println(it.filterNotNull())
    }

    address?.apply {
        println(this.filterNotNull())
    }

    val member = Member("Darshan", 21, "Rajkot").apply {
        add()
    }

    val valueLet = member.let {
        println(it)
        it.add()
        age
    }

    println(valueLet)

    val valueApply = member.apply {
        println(this)
        add()
        this.address
    }

    println(valueApply)

    val valueWith = with(member) {
        age = 22
        println(this)
        this.address
    }

    println(valueWith)

    val valueRun = member.run {
        println(this.age)
        this // return
    }

    println(valueRun)

    val memberNull: Member? = null

    memberNull?.run {
        println(this) // value is null then run is simply ignored
        println("Hello")
    }

    member.also {
        it.name = "Shubham"
        it.age = 20
        it.address = "Ahmedabad"
        println(it)
    }
    // also and apply does not any return value because its return type Unit

    val randomNumber = 50.1
    println(randomNumber)

    val numberEven = randomNumber.takeIf {
        it.toInt() % 2 == 0
    }
    println(numberEven) // condition satisfy then return object otherwise return null

    val numberOdd = randomNumber.takeUnless {
        it.toInt() % 2 != 0 // condition satisfy then return null otherwise return object
    }
    println(numberOdd)
    val strString = "Dangar Darshan"
    val range = 1..4
    val substring = strString.substring(range)
    val sub = strString.subSequence(range)
    println(sub)
    println(substring)

    val database = DataInDatabase("MusicData", 5).apply {
        size *= 5
    }
    println(database.size)
    println(database.name)
    with(database) {
        size = 50
        println(size)
    }
    println(database.size)

    DataInDatabase("VideoPlayer", 10).apply {
        this.detail()
        name = name.uppercase()
        println(name)
    }

    DataInDatabase("MxPlayer", 15).run {
        this.detail()
        name
    }

    DataInDatabase("Movie", 8).also {
        it.detail()
        it.size
    }

    val dataOfImage: DataInDatabase? = null

    dataOfImage?.run {
        println()
        println("run apply on nullable")
        this.detail()
    }

    dataOfImage?.apply {
        println()
        println("apply on nullable")
        this.detail()
    }

    dataOfImage?.also {
        it.detail()
    }

    DepartmentOf("Computer Engineer", "Make Software").apply {
        println(name)
        data()
    }

    val removeNull = listOf(1, null, 2, null)
    println(removeNull.filterNotNull())
    println(removeNull.filterNot {
        it == null
    })
}