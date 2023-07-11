package com.example.doctorchanneling

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.doctorchanneling.databinding.ItemReceiveMessageBinding
import com.example.doctorchanneling.databinding.ItemSendMessageBinding

class ChatAdapter :
    RecyclerView.Adapter<ViewHolder>() {

    private var chatsData: MutableList<ChatModel> = mutableListOf()

    class SendViewHolder(private val binding: ItemSendMessageBinding) :
        ViewHolder(binding.root) {
        fun bind(data: ChatModel) {
            binding.text = data
        }
    }

    class ReceiveViewHolder(private val binding: ItemReceiveMessageBinding) :
        ViewHolder(binding.root) {
        fun bind(data: ChatModel) {
            binding.tvReceiveMessage.text = data.data.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (MessageType.values()[viewType]) {
            MessageType.Sender -> {
                SendViewHolder(
                    ItemSendMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            MessageType.Receiver -> {
                ReceiveViewHolder(
                    ItemReceiveMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

        }
    }

    fun addChat(chat: ChatModel) {
        chatsData.add(chat)
    }

    override fun getItemCount(): Int = chatsData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is SendViewHolder -> {
                holder.bind(chatsData[position])
            }

            is ReceiveViewHolder -> {
                holder.bind(chatsData[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (chatsData[position].type == MessageType.Sender) {
            MessageType.Sender.ordinal
        } else MessageType.Receiver.ordinal
    }

}

