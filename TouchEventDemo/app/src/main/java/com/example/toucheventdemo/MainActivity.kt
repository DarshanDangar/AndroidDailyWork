package com.example.toucheventdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText ;
        val btnok: Button;

        editText = findViewById(R.id.editText)

        btnok = findViewById(R.id.btnok)
        btnok.setOnClickListener {

            val txt = editText.text.toString()
            val intent = Intent(this,WelcomeActivity::class.java)
            intent.putExtra("txt",txt)
            startActivity(intent)


        }
    }
}