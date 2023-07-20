package com.example.userlistdemo.utils

import com.example.userlistdemo.data.remote.UserListApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val baseUrl = "https://reqres.in/"

private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level =
        HttpLoggingInterceptor.Level.HEADERS
}

private val client: OkHttpClient =
    OkHttpClient.Builder().addInterceptor(CustomInterceptor()).addInterceptor(
        httpLoggingInterceptor
    ).build()

val retrofit: UserListApiService = Retrofit.Builder()
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(baseUrl)
    .build()
    .create(UserListApiService::class.java)