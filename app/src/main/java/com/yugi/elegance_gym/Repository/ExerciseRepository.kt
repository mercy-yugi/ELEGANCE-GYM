package com.yugi.elegance_gym.Repository

import com.yugi.elegance_gym.Api.ApiClient
import com.yugi.elegance_gym.Api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExerciseRepository {
    val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun fetchExerciseCategory(accessToken:String)= withContext(Dispatchers.IO){
      return@withContext apiClient.fetchExerciseCategories(accessToken)
    }
}