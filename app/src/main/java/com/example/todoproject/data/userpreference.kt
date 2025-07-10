package com.example.todoproject.data.remote

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserPreferences(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

    private val _userFlow = MutableStateFlow(getToken())
    val userFlow: Flow<String?> = _userFlow.asStateFlow()

    fun saveToken(token: String) {
        prefs.edit().putString("jwt_token", token).apply()
        _userFlow.value = token
    }

    fun getToken(): String? {
        return prefs.getString("jwt_token", null)
    }
}
