package com.yugi.elegance_gym.UI

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences("ELEGANCE-GYM_PREFS", MODE_PRIVATE)
        val accessToken=sharedPreferences.getString("ACCESS_TOKEN","")
        if (accessToken!!.isNotBlank()){
            startActivity(Intent(this, Landingpage_activity::class.java))
        }
        else{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}