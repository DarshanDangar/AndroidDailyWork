package com.example.doctorchanneling

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.doctorchanneling.databinding.ActivityCreateAccountBinding
import com.example.doctorchanneling.helper.SharedPreferenceHelper
import com.example.doctorchanneling.home.HomeActivity

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_account)
        binding.btnSignIn.setOnClickListener {
            if (binding.etEmail.text?.isEmpty() == true || binding.etPassword.text?.isEmpty() == true || binding.etMobileNo.text?.isEmpty() == true || binding.etFullName.text?.isEmpty() == true) {
                Toast.makeText(this, "Please Fill all Field", Toast.LENGTH_SHORT).show()
            } else {
                if (binding.etEmail.text?.let { it1 -> Patterns.EMAIL_ADDRESS.matcher(it1).matches() } == true) {
                    SharedPreferenceHelper.putBoolean("signin", true)
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

}

