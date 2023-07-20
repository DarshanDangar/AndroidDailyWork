package com.example.userlistdemo.ui.authentication

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.userlistdemo.R
import com.example.userlistdemo.databinding.ActivityLogInBinding
import com.example.userlistdemo.utils.SharedPreferenceHelper
import com.example.userlistdemo.ui.users.UserListActivity

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    private val userViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPreferenceHelper.initialize(application)
        checkForLogin()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_log_in)
        binding.btnSignIn.setOnClickListener {
            userViewModel.validation(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            )
            checkForLogin()
        }
    }

    private fun checkForLogin() {
        if (userViewModel.checkSignIn()) {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}