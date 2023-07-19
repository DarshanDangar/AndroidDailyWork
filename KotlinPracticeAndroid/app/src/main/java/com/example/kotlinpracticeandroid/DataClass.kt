package com.example.kotlinpracticeandroid

data class Hospital(val name: String, var address: String)

data class Bank(val userAcno: Long, var balance: Long)

fun main() {

    val hospital = Hospital("Shree-ji Hospital", "Gondal")
    println(hospital)

    val bank = Bank(36930000000, 50000)
    println(bank.copy(userAcno = 37888800000))
    println(bank.toString())
    println(bank)
    println(bank.hashCode())
    println(bank.component1())
    val balance = bank.component2()
    println(balance)

    val newAcno = bank.copy(userAcno = 352451510000, balance = 58245423)
    println(newAcno)
    println(newAcno.hashCode())

    val newBank = bank.copy(userAcno = 256501501512, balance = 5555555)
    println(newBank)

    if (bank == newBank) {
        println("bank and new bank both equals")
    }

    val (name, address) = hospital
    println(name)
    println(address)

}