package com.yugi.elegance_gym.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yugi.elegance_gym.Repository.UserRepository
import com.yugi.elegance_gym.models.LoginRequest
import com.yugi.elegance_gym.models.LoginResponse
import com.yugi.elegance_gym.models.RegisterRequest
import com.yugi.elegance_gym.models.RegisterResponse
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepository=UserRepository()
    var loginResponseLiveData=MutableLiveData<LoginResponse>()
    val loginErrorLiveData=MutableLiveData<String?>()
    var registerResponseLiveData=MutableLiveData<RegisterResponse>()
    val registerErrorLiveData=MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response=userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
              loginResponseLiveData.postValue(response.body())
            }
            else{
               val error=response.errorBody()?.string()
                loginErrorLiveData.postValue(response.errorBody()?.toString())
            }
        }
    }

    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response=userRepository.register(registerRequest)
            if (response.isSuccessful){
                registerResponseLiveData.postValue(response.body())
            }
            else{
                val error=response.errorBody()?.string()
                registerErrorLiveData.postValue(error)
            }
        }
    }
}