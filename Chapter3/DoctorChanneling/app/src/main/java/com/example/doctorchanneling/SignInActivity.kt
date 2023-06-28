package com.example.doctorchanneling

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.doctorchanneling.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivitySignInBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)

        if (binding.etEmail.text?.isEmpty() == true && binding.etPassword.text?.isEmpty() == true) {
            Toast.makeText(this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show()
        } else {
//            binding.btnSignUp.isEnabled = true
            if (Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text).matches()) {
                binding.btnSignUp.setOnClickListener {
                    Toast.makeText(this, "sign in clicked", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "email is not valid", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvDontHaveAnAccount.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }
}