package com.example.firstandroidui

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.firstandroidui.databinding.ActivitySignInBinding


class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var loginModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        loginModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.viewmodel = loginModel

        if (binding.txtEmail.text?.isEmpty() == true && binding.txtEPassword.text?.isEmpty() == true) {
            Toast.makeText(this, "please Enter Email and Password", Toast.LENGTH_SHORT).show()
        } else {
            if (Patterns.EMAIL_ADDRESS.matcher(binding.txtEmail.text).matches()) {
                binding.signIn.setOnClickListener {
                    Toast.makeText(this, "sign in clicked", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "email is not valid", Toast.LENGTH_SHORT).show()
            }
        }
    }

}