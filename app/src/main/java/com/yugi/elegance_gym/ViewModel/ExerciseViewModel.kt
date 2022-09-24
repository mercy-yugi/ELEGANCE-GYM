package com.yugi.elegance_gym.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yugi.elegance_gym.Repository.ExerciseRepository
import com.yugi.elegance_gym.models.ExerciseCatagory
import kotlinx.coroutines.launch

class ExerciseViewModel :ViewModel(){
    val exerciseRepository=ExerciseRepository()
    val exerciseCategoryLiveData=MutableLiveData<List<ExerciseCatagory>>()
    val errorLiveData=MutableLiveData<String?>()

    fun fetchExerciseCategories(accessToken:String){
      viewModelScope.launch {
          val response=exerciseRepository.fetchExerciseCategory(accessToken)
          if (response.isSuccessful){
              exerciseCategoryLiveData.postValue(response.body())
          }
          else{
              val errorMsg=response.errorBody()?.string()
              errorLiveData.postValue(errorMsg)
          }
      }
    }
}