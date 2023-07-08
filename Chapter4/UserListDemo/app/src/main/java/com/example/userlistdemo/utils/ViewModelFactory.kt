package com.example.userlistdemo.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.userlistdemo.data.repository.UserRepository
import com.example.userlistdemo.ui.users.UserViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel() as T
    }
}