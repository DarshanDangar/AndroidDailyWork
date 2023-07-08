package com.example.userlistdemo.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceHelper {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun initialize(context: Context) {
        sharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value).commit()
    }

    fun getBoolean(key: String?, defValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defValue)
    }
}
