package com.example.kotlinpracticeandroid

var emptyProperty: String = ""
const val intNumber = 5;
class Address {

    var address: String = "MD"
    var city: String = "Rajkot"
    var street: String = "KR"
    var zipcode: String = "360331"

    fun hello() {
        val greetingPerson  =  fun (greeting: () -> Unit ) {
            greeting()
        }
    }
}

fun detailsOfAddress(address: Address): Address{
    val result = Address()
    result.address = address.address
    result.city = address.city
    result.street = address.street
    result.zipcode = address.zipcode
    return result
}

class Square(private var side: Int) {

    private var extra = 0
    var area: Int
        get() {
            return side * side
        } set(value) {
            extra = value
        }
    val areaOfSquare get() = side * side * side
    var rectArea: Int
    get() {
        return area
    } set(value) {
        area = areaOfSquare
    }

}

class Radius {

    var radius: Int = 0
        set(value) {
        if (value > 10) {
            field = 10
        }
    }

}

class PrivateSet {
    var hd: Int = 0
}

fun main() {
    val address = Address()
    val details = detailsOfAddress(address)
    println(details.city)
    println(details.address)
    println(details.zipcode)
    println(details.street)
    details.hello()

    val squareArea = Square(5)
    println(squareArea.area)
    println(squareArea.areaOfSquare)
    println(squareArea.rectArea)
    squareArea.rectArea = 5
    println(squareArea.area)

    val getSet = Radius()
    getSet.radius = 12
    println(getSet.radius)

    val privateSet = PrivateSet()
    privateSet.hd = 100
}