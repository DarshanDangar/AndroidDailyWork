package com.example.firstandroidui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview_demo)
        val recycler = findViewById<RecyclerView>(R.id.recyclerViewDemo)
        recycler.layoutManager = GridLayoutManager(this, 3)
        recycler.adapter = MyAdapter()
    }
}