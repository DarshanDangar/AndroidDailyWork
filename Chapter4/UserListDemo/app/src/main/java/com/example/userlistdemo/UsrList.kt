package com.example.userlistdemo

import com.google.gson.annotations.SerializedName

data class User(
    val page: Long,
    @SerializedName("per_page")
    val perPage: Long,
    val total: Long,
    @SerializedName("total_pages")
    val totalPages: Long,
    val data: List<UserDetails>,
    val support: Support,
)

data class UserDetails(
    val id: Long,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String,
)

data class Support(
    val url: String,
    val text: String,
)
