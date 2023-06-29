package com.example.doctorchanneling

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorchanneling.databinding.ItemMessageBinding

class MessageAdapter(private var doctor: List<Doctor>?, val dataProvide: DataProvider?) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Doctor) {
            binding.data = data
            binding.executePendingBindings()
        }

    }

    fun filterList(filterList: List<Doctor>?) {
        if (filterList != null) {
            doctor = filterList
        } else {
            doctor = null
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            ItemMessageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

        holder.bind((doctor?.get(position) ?: 0) as Doctor)
        holder.itemView.setOnClickListener {
            dataProvide?.getData()
        }
    }

    override fun getItemCount(): Int {
        return doctor?.size ?: 0
    }

}