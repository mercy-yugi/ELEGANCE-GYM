package com.yugi.elegance_gym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class Login_activity : AppCompatActivity() {
    lateinit var tilEmail:TextInputLayout
    lateinit var tilPassword:TextInputLayout
    lateinit var etEmail:EditText
    lateinit var etPassword:EditText
    lateinit var btnLogin1:Button
    lateinit var tvSign:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnLogin1 = findViewById(R.id.btnLogin1)
        btnLogin1.setOnClickListener {
            val intent = Intent(this, Landingpage_activity::class.java)
            startActivity(intent)
        }
        tvSign = findViewById(R.id.tvSign)
        tvSign.setOnClickListener {
            val intent = Intent(this, SignUp_activity::class.java)
            startActivity(intent)
        }

    }

}