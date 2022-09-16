package com.yugi.elegance_gym.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yugi.elegance_gym.R
import com.yugi.elegance_gym.databinding.ActivityLoginBinding
import com.yugi.elegance_gym.models.LoginResponse

class Landingpage_activity : AppCompatActivity() {
    lateinit var bnvHome:BottomNavigationView
    lateinit var fcvHome:FragmentContainerView
    lateinit var sharedPrefs:SharedPreferences
    lateinit var tvLogout:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landingpage)
        costViews()
        setupBottomNav()
        tvLogout=findViewById(R.id.tvLogout)
        tvLogout.setOnClickListener {  }
        tvLogout.setOnClickListener {
            val editor=sharedPrefs.edit()
            editor.putString("ACCESS_TOKEN","")
            editor.putString("USER_ID","")
            editor.putString("PROFILE_ID","")
            editor.apply()
            startActivity(Intent(this,LoginResponse::class.java))
        }
    }
    fun costViews(){
        fcvHome=findViewById(R.id.fcvHome)
        bnvHome=findViewById(R.id.bnvHome)
    }
    fun setupBottomNav(){
        bnvHome.setOnItemSelectedListener{item->
            when(item.itemId){
                R.id.plan ->{
                    val transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, planfragment())
                    transaction.commit()
                    true
                }
                R.id.track ->{
                    val transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, TrackFragment2())
                    transaction.commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fcvHome,
                        profileFragment()
                    )
                    true
                }
                else->false
            }
        }
    }
}