package com.example.kotlinpracticeandroid

import java.util.*

// Properties

var emptyProperty: String = ""
val intNumber = 5;

class Address {

    var address: String = "MD"
    var city: String = "Rjkt"
    var street: String = "KR"
    var zipcode: String = "360331"
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

    get() = field
    set(value) {
        if (value > 10) {
            field = 10
        }
    }



}

class PrivateSet {
    var hd: Int = 0
    private set
}


fun main() {
    val address = Address()
    val det = deatls(address)
    println(det.city)
    println(det.address)
    println(det.zipcode)
    println(det.street)

    var squareArea = Square(5)
    println(squareArea.area)
    println(squareArea.areaofSquare)
    println(squareArea.rectArea)
    squareArea.rectArea = 5
    println(squareArea.area)

    var getset = GetSet()
    getset.radius = 12
    println(getset.radius)

    var hd = PrivateSet()

    var jkl = UUID.randomUUID()
    // println(jkl as? String?)

    var x = null

    var y = x as? String
    println(y is String?)

    var z = x as? String?
    println(z is String?)

    var b = x as String?
    println(b is String)

//    var a = x as String
//    println(a is String)

}