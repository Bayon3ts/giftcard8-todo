package com.example.todoproject.data.repository

interface AuthRepository {
    suspend fun login(email: String, password: String): Boolean
}
