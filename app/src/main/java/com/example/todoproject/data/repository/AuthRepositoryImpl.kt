    package com.example.todoproject.data.repository

    import com.example.todoproject.data.model.LoginRequest
    import com.example.todoproject.data.remote.AuthApi
    import com.example.todoproject.data.remote.UserPreferences
    import kotlinx.coroutines.Dispatchers
    import kotlinx.coroutines.withContext

    class AuthRepositoryImpl(
        private val authApi: AuthApi,
        private val userPreferences: UserPreferences
    ) : AuthRepository {

        override suspend fun login(email: String, password: String): Boolean = withContext(Dispatchers.IO) {
            val response = authApi.login(LoginRequest(email, password))
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null && body.token.isNotEmpty()) {
                    userPreferences.saveToken(body.token)
                    return@withContext true
                }
            }
            return@withContext false
        }
    }
