package com.example.userlistdemo.ui.users

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userlistdemo.databinding.ItemUserListBinding
import com.example.userlistdemo.data.remote.request.UserDetails

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    private var listOfUser = listOf<UserDetails>()

    class ViewHolder(private val binding: ItemUserListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: UserDetails) {
            binding.data = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemUserListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = listOfUser.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfUser[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<UserDetails>) {
        listOfUser = list
        notifyDataSetChanged()
    }

}