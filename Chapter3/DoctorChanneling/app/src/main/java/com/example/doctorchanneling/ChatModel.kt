package com.example.doctorchanneling

data class ChatModel(val data: String?, val type: MessageType)

enum class MessageType {
    Sender,
    Receiver
}