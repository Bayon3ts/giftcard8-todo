// File: AuthApi.kt
package com.example.todoproject.data.remote


import com.example.todoproject.data.model.LoginRequest
import com.example.todoproject.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}

