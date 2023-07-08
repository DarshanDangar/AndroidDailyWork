package com.example.userlistdemo.data.remote

import com.example.userlistdemo.data.remote.request.UserRequest
import com.example.userlistdemo.data.remote.response.UserResponse
import com.example.userlistdemo.data.remote.request.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Query

interface UserListApiService {

    @GET("api/users")
    fun getDetails(@HeaderMap headers: Map<String, String>, @Query("page") page: Int): Call<User>

    @POST("api/register")
    suspend fun passDetails(@Body userRequest: UserRequest): Response<UserResponse>

}