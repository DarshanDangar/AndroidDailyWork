package com.example.firstandroidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var btnSWitch: Button
    lateinit var btnRadio: Button
    lateinit var btnCheckbox: Button
    lateinit var snackbar: Snackbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSWitch = findViewById(R.id.btnSwitch)
        btnRadio = findViewById(R.id.btnRadio)
        btnCheckbox = findViewById(R.id.btncheckbox)
        btnSWitch.setOnClickListener {
            Toast.makeText(this, "Switch is On and Off",Toast.LENGTH_SHORT).show()
        }
        btnCheckbox.setOnClickListener {
//            Snackbar.make(View(this), "Added", Snackbar.LENGTH_SHORT).show()
        }
    }

}