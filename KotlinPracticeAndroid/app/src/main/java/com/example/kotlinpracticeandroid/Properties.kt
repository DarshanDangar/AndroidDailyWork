package com.example.kotlinpracticeandroid

// Properties

var emptyProperty: String = ""
val intNumber = 5;
class Address {

    var address: String = "MD"
    var city: String = "Rjkt"
    var street: String = "KR"
    var zipcode: String = "360331"

    fun hello() {
        val greetingPerson  =  fun (greeting: () -> Unit ) {
            greeting()
        }
    }
}

fun deatls(address: Address): Address{

    val result = Address()
    result.address = address.address
    result.city = address.city
    result.street = address.street
    result.zipcode = address.zipcode

    return result
}

class Square(var side: Int) {

    private var extra = 0
    var area: Int
        get() {
            return side * side
        } set(value) {
            extra = value
        }
    val areaofSquare get() = side * side * side
    var rectArea: Int
    get() {
        return area
    } set(value) {
        area = areaofSquare
    }

//    val isEmpty: Boolean
//        get() = this.size == 0

}

class GetSet {

    var radius: Int = 0
        set(value) {
        if (value > 10) {
            field = 10
        }
    }

}

class PrivateSet {
    var hd: Int = 0
    set(value) {
        field = value
    }
}

fun main() {
    val address = Address()
    val details = deatls(address)
    println(details.city)
    println(details.address)
    println(details.zipcode)
    println(details.street)
    details.hello()

    val squareArea = Square(5)
    println(squareArea.area)
    println(squareArea.areaofSquare)
    println(squareArea.rectArea)
    squareArea.rectArea = 5
    println(squareArea.area)

    val getset = GetSet()
    getset.radius = 12
    println(getset.radius)

    val privateSet = PrivateSet()
    privateSet.hd = 100
}