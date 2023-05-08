package com.example.kotlinpracticeandroid

import kotlin.properties.Delegates

interface NotifyManager {
   fun notification()
}

class Men: NotifyManager {
   override fun notification() {
       println("Notification added")
   }

  }

class Samsung(notification: NotifyManager): NotifyManager by notification {
    fun added() {
        println("Notify successfully")
    }
}
interface Download {
    fun download()
}

class User(val filename: String): Download {
    override fun download() {
        println("$filename File is downloaded")
    }
}

class Device(val filename: Download) {
    fun isDownload() {
        filename.download()
        println("Delegation complete")
    }
}

val lazyProperty: String by lazy {
    println("Hello")
    "Darshan"
}

var temperature: Double by Delegates.observable(0.0) {prop, old, new ->
    println(prop)
    println("old: $old -> new: $new")
}

class Temperature(val temp: Double, val fern: Double) {
    val temperature: Double by this::temp
    val ferenheat: Double by this::fern
}

class StoredKeyValue(val map: Map<String, Any>){
    val name: String by map
    val age: Int by map
}

fun main() {
    val men = Men()
    val samsung = Samsung(men)
    samsung.notification()
    samsung.added()

    val user = User("Movie")
    val device = Device(user)
    device.isDownload()
    println(lazyProperty)
    println(lazyProperty)

    temperature = 27.8
    temperature = 28.8

    val temp = Temperature(27.8,52.2)
    println(temp.temperature)
    println(temp.ferenheat)

    val storedKeyValue = StoredKeyValue(mapOf(
        "name" to "Darshan",
        "age" to 21,
        "name" to "Shyam",
        "age" to 21,
        "name" to "Shubham",
        "age" to 20
    ))

    println(storedKeyValue.map)
    println(storedKeyValue.name)
    println(storedKeyValue.age)


}