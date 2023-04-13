package com.example.kotlinpracticeandroid

data class Hospital(val name: String, var address: String)

data class Bank(val userAcno: Long, var balance: Long)

fun main() {

    var hospital = Hospital("Shree-ji Hospital", "Gondal")
//    println(hospital.name)
//    println(hospital.address)
    println(hospital)

    var bank = Bank(36930000000, 50000)
    println(bank.copy(userAcno = 37888800000))
    println(bank.toString())
    println(bank)
    println(bank.hashCode())

    println(bank.component1())
    var bal = bank.component2()
    println(bal)

    var newAcno = bank.copy(352451510000, 58245423)
    println(newAcno)
    println(newAcno.hashCode())

    var newBank = bank.copy()
    println(newBank.hashCode())

    if (bank.equals(newBank)) {
        println("bank and new bank both equals")
    }

    val(name, address) = hospital
    println(name)
    println(address)



}