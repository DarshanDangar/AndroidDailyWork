package com.example.doctorchanneling

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorchanneling.databinding.ItemActiveProfileBinding

class ProfileAdapter(private val profile: List<Profile>) :
    RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemActiveProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(profile: Profile) {
            binding.profile = profile
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.ViewHolder {
        return ViewHolder(
            ItemActiveProfileBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfileAdapter.ViewHolder, position: Int) {
        holder.bind(profile[position])
    }

    override fun getItemCount(): Int {
        return profile.size
    }
}