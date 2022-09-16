package com.yugi.elegance_gym.Repository

import com.yugi.elegance_gym.Api.ApiClient
import com.yugi.elegance_gym.Api.ApiInterface
import com.yugi.elegance_gym.models.LoginRequest
import com.yugi.elegance_gym.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest)= withContext(Dispatchers.IO){
        val response=apiClient.login(loginRequest)
        return@withContext response
    }

    suspend fun register(registerRequest: RegisterRequest)= withContext(Dispatchers.IO){
        val response=apiClient.register(registerRequest)
        return@withContext response
    }


}