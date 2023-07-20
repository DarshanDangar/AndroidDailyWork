package com.example.userlistdemo.data.repository

import com.example.userlistdemo.utils.retrofit
import com.example.userlistdemo.data.remote.request.UserRequest
import com.example.userlistdemo.data.remote.response.UserResponse
import retrofit2.Response

class AuthenticationRepository {

    suspend fun passUserDetails(userRequest: UserRequest): Response<UserResponse> =
        retrofit.passDetails(userRequest)

}