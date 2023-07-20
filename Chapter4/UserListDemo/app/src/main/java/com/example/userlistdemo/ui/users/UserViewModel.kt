package com.example.userlistdemo.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userlistdemo.data.repository.UserRepository
import com.example.userlistdemo.data.remote.request.User

class UserViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _userDetails = MutableLiveData<User>()
    val userDetails: LiveData<User> = _userDetails
    private val repo = UserRepository()

    fun getUserDetails() {
        repo.getUser {
            _userDetails.value = it
        }

        repo.status.observeForever {
            _status.value = it
        }
    }

}