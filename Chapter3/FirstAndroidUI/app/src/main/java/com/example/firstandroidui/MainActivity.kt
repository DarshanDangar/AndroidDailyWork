package com.example.firstandroidui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var btnSWitch: Button
    private lateinit var btnRadio: Button
    private lateinit var btnCheckbox: Button
    private lateinit var snackbar: Snackbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSWitch = findViewById(R.id.btnSwitch)
        btnRadio = findViewById(R.id.btnRadio)
        btnCheckbox = findViewById(R.id.btncheckbox)
        btnSWitch.setOnClickListener {
            Toast.makeText(this, "Switch is On and Off", Toast.LENGTH_SHORT).show()
        }
        btnCheckbox.setOnClickListener {
            Snackbar.make(View(this), "Added", Snackbar.LENGTH_SHORT).show()
        }
    }

}