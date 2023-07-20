package com.example.firstandroidui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstandroidui.databinding.ItemCallBinding
import com.example.firstandroidui.home.CallListDetails

class CallAdapter(private val calls: List<CallListDetails>) :
    RecyclerView.Adapter<CallAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: ItemCallBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CallListDetails) {
            binding.data = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCallBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return calls.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(calls[position])
    }

}