package com.example.firstandroidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.firstandroidui.databinding.ActivitySignInBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar
import kotlin.math.log


class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    lateinit var txtPassword: EditText
    lateinit var tvForgotPassword: TextView
    lateinit var btnSignIn: MaterialButton
    lateinit var imgSignInWithGoogle: MaterialCardView
    lateinit var imgSignInWithMicrosoft: MaterialCardView
    lateinit var imgSignInWithApple: MaterialCardView
    private lateinit var loginModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in)
//        binding.txtEmail.hint = "Email"
        loginModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.viewmodel = loginModel
        // txtEmail = findViewById(R.id.txtE_email)
        txtPassword = findViewById(R.id.txtE_password)
        tvForgotPassword = findViewById(R.id.forgotPassword)
        btnSignIn = findViewById(R.id.signIn)
        imgSignInWithGoogle = findViewById(R.id.signInWithGoogle)
        imgSignInWithMicrosoft = findViewById(R.id.signInWithMicrosoft)
        imgSignInWithApple = findViewById(R.id.signInWithApple)

//        if (txtEmail.getText().isNotEmpty()) {
//            Toast.makeText(this, "Email added",Toast.LENGTH_SHORT).show()
//        }

//        btnSignIn.setOnClickListener {
//            if (txtEmail.text.isNotEmpty() && txtPassword.text.isNotEmpty()) {
//                if (Patterns.EMAIL_ADDRESS.matcher(txtEmail.text).matches()) {
//                    Toast.makeText(this, "sign in clicked",Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this, "email is not valid",Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(this, "please Enter Email and Password",Toast.LENGTH_SHORT).show()
//            }
//        }

        imgSignInWithGoogle.setOnClickListener {
            val snackbar = Snackbar.make(
                it, "Sign In with Google",
                Snackbar.LENGTH_LONG
            ).setAction("Action", null)
            snackbar.show()
        }

        imgSignInWithMicrosoft.setOnClickListener {  }
    }


}