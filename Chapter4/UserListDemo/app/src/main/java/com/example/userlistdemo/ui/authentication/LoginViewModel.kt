package com.example.userlistdemo.ui.authentication

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userlistdemo.utils.SharedPreferenceHelper
import com.example.userlistdemo.data.remote.request.UserRequest
import com.example.userlistdemo.data.repository.AuthenticationRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var isValid: Boolean = false
    private var isSignin = false
    private val repo = AuthenticationRepository()

    fun passUserDetails(userRequest: UserRequest) {
        viewModelScope.launch {
            if (isValid) {
                repo.passUserDetails(userRequest).body()?.id
            }
        }
    }

    fun validation(email: String, password: String) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            SharedPreferenceHelper.putBoolean("signin", true)
            val userData = UserRequest(email, password)
            isValid = true
            isSignin = true
            passUserDetails(userData)
        }
    }

    fun checkSignIn(): Boolean {
        return SharedPreferenceHelper.getBoolean("signin", false)
    }
}