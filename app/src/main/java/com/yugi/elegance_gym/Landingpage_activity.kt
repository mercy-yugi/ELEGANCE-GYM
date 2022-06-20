package com.yugi.elegance_gym

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class Landingpage_activity : AppCompatActivity() {
    lateinit var bnvHome:BottomNavigationView
    lateinit var fcvHome:FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landingpage)
        costViews()
        setupBottomNav()
    }
    fun costViews(){
        fcvHome=findViewById(R.id.fcvHome)
        bnvHome=findViewById(R.id.bnvHome)
    }
    fun setupBottomNav(){
        bnvHome.setOnItemSelectedListener{item->
            when(item.itemId){
                R.id.plan->{
                    val transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome,planfragment())
                    transaction.commit()
                    true
                }
                R.id.track->{
                    val transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome,TrackFragment2())
                    transaction.commit()
                    true
                }
                R.id.profile->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,profileFragment())
                    true
                }
                else->false
            }
        }
    }
}