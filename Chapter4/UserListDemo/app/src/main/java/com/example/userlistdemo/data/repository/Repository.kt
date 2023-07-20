package com.example.userlistdemo.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.userlistdemo.utils.retrofit
import com.example.userlistdemo.data.remote.request.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    fun getUser(callback: (User) -> Unit) {
        val headerMap = mutableMapOf<String, String>()
        headerMap["Cache-Control"] = "max-age"
        headerMap["Accept-Path"] = "Darshan"
        val res = retrofit.getDetails(headerMap, 1)
        Log.d("res", "getUser: $res")
        res.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { callback(it) }
                Log.d("header", response.headers().toString())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                _status.value = "Something Went Wrong"
            }
        })
    }

}