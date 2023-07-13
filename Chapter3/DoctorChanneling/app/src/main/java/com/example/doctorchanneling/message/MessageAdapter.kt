package com.example.doctorchanneling.message

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorchanneling.R.color.light_blue
import com.example.doctorchanneling.chat.DataProvider
import com.example.doctorchanneling.databinding.ItemMessageBinding
import com.example.doctorchanneling.profile.Doctor

class MessageAdapter(private var doctor: List<Doctor>?, val dataProvide: DataProvider?) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind(data: Doctor) {
            binding.data = data
            binding.tvUnreadMsg.isVisible = data.noofMsg != 0
            if (data.noofMsg != 0) this.binding.tvDegreeDescription.setTextColor(light_blue)
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
            dataProvide?.getData(bundleOf("userName" to "${doctor?.get(holder.adapterPosition)?.name}"))
            holder.itemView.id
        }

    }

    override fun getItemCount(): Int {
        return doctor?.size ?: 0
    }

}