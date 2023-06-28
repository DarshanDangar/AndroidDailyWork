package com.example.doctorchanneling.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorchanneling.databinding.FragmentHomeBinding
import com.example.doctorchanneling.profile.Doctor

class HomeAdapter(var visibleData: List<Doctor>?) :
    RecyclerView.Adapter<HomeAdapter.DoctorHolder>() {

    class DoctorHolder(val binding: FragmentHomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorHolder {
        val holder = DoctorHolder(
            FragmentHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        return holder
    }

    override fun getItemCount(): Int {
        return visibleData?.size ?: 0
    }

    override fun onBindViewHolder(holder: DoctorHolder, position: Int) {
//        holder.bind(visibleData?.get(position))
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(visibleData: List<Doctor>?) {
        this.visibleData = visibleData
        notifyDataSetChanged()
    }

}