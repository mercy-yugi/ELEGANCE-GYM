package com.yugi.elegance_gym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class SignUp_activity : AppCompatActivity() {
    lateinit var etFirstname:EditText
    lateinit var etLastname:EditText
    lateinit var etPassword1:EditText
    lateinit var etReenter:EditText
    lateinit var etEmail1:EditText
    lateinit var btnSignUp1:Button
    lateinit var tilFirstname:TextInputLayout
    lateinit var tilLastname:TextInputLayout
    lateinit var tilPassword:TextInputLayout
    lateinit var tilReenter:TextInputLayout
    lateinit var tilEmail:TextInputLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        btnSignUp1=findViewById(R.id.btnSignUp1)
        etFirstname=findViewById(R.id.etFirstname)
        etLastname=findViewById(R.id.etLastname)
        etPassword1=findViewById(R.id.etPassword1)
        etReenter=findViewById(R.id.etReenter)
        etEmail1=findViewById(R.id.etEmail1)
        tilFirstname=findViewById(R.id.tilFirstname)
        tilLastname=findViewById(R.id.tilLastname)
        tilPassword=findViewById(R.id.tilPassword)
        tilReenter=findViewById(R.id.tilReenter)
        tilEmail=findViewById(R.id.tilEmail)


        btnSignUp1= findViewById(R.id.btnSignUp1)
        btnSignUp1.setOnClickListener {
            val intent = Intent(this, Login_activity::class.java)
            startActivity(intent)
        }
    }

}