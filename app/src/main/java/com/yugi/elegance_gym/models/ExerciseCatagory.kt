package com.yugi.elegance_gym.models

import com.google.gson.annotations.SerializedName

data class ExerciseCatagory(
    @SerializedName("category_id")var categoryId:String,
    @SerializedName("category_name")var categoryName:String
)
