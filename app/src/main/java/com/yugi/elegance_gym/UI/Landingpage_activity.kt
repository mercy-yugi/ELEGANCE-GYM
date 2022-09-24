package com.yugi.elegance_gym.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yugi.elegance_gym.R
import com.yugi.elegance_gym.Util.Constants
import com.yugi.elegance_gym.ViewModel.ExerciseViewModel
import com.yugi.elegance_gym.databinding.ActivityLoginBinding
import com.yugi.elegance_gym.models.LoginResponse

class Landingpage_activity : AppCompatActivity() {
    lateinit var bnvHome:BottomNavigationView
    lateinit var fcvHome:FragmentContainerView
    lateinit var sharedPrefs:SharedPreferences
    lateinit var tvLogout:BottomNavigationView
    val exerciseViewModel:ExerciseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landingpage)
        costViews()
        setupBottomNav()
        sharedPrefs = getSharedPreferences(Constants.prefsFile, MODE_PRIVATE)
        val token = sharedPrefs.getString(Constants.accessToken, Constants.EMPTY_STRING)
    }
        override fun onResume() {
            super.onResume()
            exerciseViewModel.exerciseCategoryLiveData.observe(this, Observer { exerciseCategory ->
                Toast.makeText(baseContext,"fetched ${exerciseCategory.size} categories",Toast.LENGTH_LONG).show()
            })
            exerciseViewModel.errorLiveData.observe(this, Observer{ error ->
                Toast.makeText(this, "fetched ${error} error",Toast.LENGTH_LONG).show()
            })
        }
    fun castViews(){
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