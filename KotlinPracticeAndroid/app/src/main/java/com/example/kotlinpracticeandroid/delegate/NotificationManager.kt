package com.example.kotlinpracticeandroid.delegate

interface NotificationManager {
    fun sendNotification()
}

class NotificationManagerImpl : NotificationManager {
    override fun sendNotification() {
        println("Notified")
    }
}

class Samsung(private val notificationManager: NotificationManager) :
    NotificationManager by notificationManager

class Oneplus(private val notificationManager: NotificationManager) :
    NotificationManager by notificationManager

fun main() {
    val notificationManager = NotificationManagerImpl()
    val samsung = Samsung(notificationManager)
    samsung.sendNotification()
    val oneplus = Oneplus(notificationManager)
    oneplus.sendNotification()
}