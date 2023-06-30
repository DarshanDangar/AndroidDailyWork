package com.example.doctorchanneling

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import com.example.doctorchanneling.databinding.ActivitySignInBinding


class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        SharedPreferenceHelper.initialize(applicationContext)
        checkSignIn()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        checkEmailAndPassword()
        binding.tvDontHaveAnAccount.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
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

    private fun checkEmailAndPassword() {
        binding.etEmail.doOnTextChanged { text, start, before, count ->
            if (text?.isEmpty() == true && binding.etPassword.text?.isEmpty() == true) {
                Toast.makeText(this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show()
            } else {
                binding.btnSignIn.setOnClickListener {
                    if (Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text).matches()) {
                        SharedPreferenceHelper.putBoolean("signin", true)
                        Toast.makeText(this, "sign in clicked", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Plese Enter Email and Password", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

}