package com.example.firstandroidui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_call, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 100
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

}