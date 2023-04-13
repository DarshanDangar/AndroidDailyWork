package com.example.kotlinpracticeandroid

class TransportVehicle {
    val numberMem = 50
    inner class Bus {
        fun busAvailable() {
            println("Yes, Bus is available")
            println(numberMem)
        }
    }

    sealed class Volvo {
        fun volvo() {
            println("Volvo is sealed class member")
        }
    }

    class VolvoBus: Volvo() {

    }

    data class Gsrtc(val name: String, val root: String)

    interface Maintainance {
        fun isNeed()
        fun condition()
    }

    private class MemberBus {
        fun isMember() {
            println("private member calles")
        }
    }

    class Midibus: Maintainance {
        override fun condition() {
            println("midibus condition is very bad")
        }

        override fun isNeed() {
            println("Yes midibus must need meantainance")
        }
    }

}

fun main() {

    val bus = TransportVehicle().Bus()
    bus.busAvailable()
    val volvo = TransportVehicle.VolvoBus() // sealed class
    volvo.volvo()
    val gsrtc = TransportVehicle.Gsrtc("Saurashtra", "Rajkot-Bhavanagar")
    println(gsrtc) // data class
    val midibus = TransportVehicle.Midibus()
    midibus.isNeed()
    midibus.condition()

}