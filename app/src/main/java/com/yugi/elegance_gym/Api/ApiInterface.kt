package com.yugi.elegance_gym.Api

import com.yugi.elegance_gym.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    suspend fun register(registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST("/login")
   suspend fun login(loginRequest: LoginRequest): Response<LoginResponse>
    fun registerUser(registerRequest: RegisterRequest): Any


    @POST("/excercise-categories")
    suspend fun fetchExerciseCategories(@Header("Authorization")accessToken:String):Response<List<ExerciseCatagory>>

}