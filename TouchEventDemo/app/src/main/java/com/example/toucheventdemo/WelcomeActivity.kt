package com.example.toucheventdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        var text: TextView = findViewById(R.id.welcometxt)
        text.text = "Welcome" +" "+ intent.getStringExtra("txt")+" " +"to my application"
    }
}