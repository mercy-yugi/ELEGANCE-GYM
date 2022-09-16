package com.yugi.elegance_gym.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("phone_number")var phoneNumber:String,
    @SerializedName("first_name")var firstName:String,
    @SerializedName("last_name")var lastName:String,
    var email:String,
    @SerializedName("user_Id")var userId:String
)
