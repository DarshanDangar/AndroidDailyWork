package com.example.kotlinpracticeandroid

open class TransportVehicle {

    val capicityOfVehicle = 50

    inner class Bus {
        fun busAvailable() {
            println("Yes, Bus is available")
            println(capicityOfVehicle)
        }
    }

    sealed class Volvo {
        fun volvo() {
            println("Volvo is sealed class member")
        }
    }

    open class VolvoBus : Volvo()

    data class Gsrtc(val name: String, val root: String)

    interface Maintenance {
        fun isNeed()
        fun condition()
    }

    private class MemberBus {
        fun isMember() {
            println("private member called")
        }
    }

    open class Midibus : Maintenance {
        override fun condition() {
            println("midibus condition is very bad")
        }

        override fun isNeed() {
            println("Yes midibus must need maintenance")
        }
    }

    enum class Day {
        Monday
    }

    abstract class Type

    @JvmInline
    value class HJUv(val name: String)

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