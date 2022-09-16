package com.yugi.elegance_gym.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    var message:String,
    @SerializedName("first_name")var access_token: String,
    @SerializedName("last_name")var profile_id:String,
    @SerializedName("phone_number")var user_id:String,

)
