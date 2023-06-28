package com.example.doctorchanneling.authentication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import com.example.doctorchanneling.R
import com.example.doctorchanneling.databinding.ActivitySignInBinding
import com.example.doctorchanneling.helper.SharedPreferenceHelper
import com.example.doctorchanneling.home.HomeActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        SharedPreferenceHelper.initialize(applicationContext)
        checkSignIn()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        binding.tvDontHaveAnAccount.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignIn.setOnClickListener {
            if (binding.etEmail.text?.isEmpty() == true || binding.etPassword.text?.isEmpty() == true) {
                Toast.makeText(this, "Please Enter Email & Password", Toast.LENGTH_SHORT).show()
            } else if (binding.etEmail.text?.let { it1 ->
                    Patterns.EMAIL_ADDRESS.matcher(it1).matches()
                } == true) {
                SharedPreferenceHelper.putBoolean("signin", true)
                Toast.makeText(this, "sign in clicked", Toast.LENGTH_SHORT).show()
                checkSignIn()
            } else {
                Toast.makeText(this, getString(R.string.plese_enter_email_and_password), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun checkSignIn() {
        val isSignedIn = SharedPreferenceHelper.getBoolean("signin", false)
        if (isSignedIn) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}


