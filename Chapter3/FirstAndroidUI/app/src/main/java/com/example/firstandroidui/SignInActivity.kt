package com.example.firstandroidui

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.firstandroidui.databinding.ActivitySignInBinding
import com.example.firstandroidui.helper.SharedPreferenceHelper
import com.example.firstandroidui.home.HomeActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPreferenceHelper.initialize(application)
        checkSignIn()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        binding.signIn.setOnClickListener {
            if (binding.txtEmail.text?.isEmpty() == true && binding.txtEPassword.text?.isEmpty() == true) {
                Toast.makeText(
                    this,
                    getString(R.string.please_enter_email_and_password),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (Patterns.EMAIL_ADDRESS.matcher(binding.txtEmail.text).matches()) {
                    Toast.makeText(this, getString(R.string.sign_in_clicked), Toast.LENGTH_SHORT)
                        .show()
                    SharedPreferenceHelper.putBoolean("login", true)
                    checkSignIn()
                }
            }
        }

    }

    private fun checkSignIn() {
        if (SharedPreferenceHelper.getBoolean("login", false)) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}
