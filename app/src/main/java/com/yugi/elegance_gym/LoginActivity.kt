package com.yugi.elegance_gym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import com.yugi.elegance_gym.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
  lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogin1.setOnClickListener {
            checkLogin()
            startActivity(Intent(this, Landingpage_activity::class.java))
            finish()
        }

        binding.tvSign.setOnClickListener {
            val intent = Intent(this, SignUp_activity::class.java)
            startActivity(intent)
        }

    }
    fun checkLogin(){
        val email= binding.etEmail.text.toString()
        val password= binding.etPassword1.text.toString()
        var error=false

        if (email.isBlank()){
            binding.tilEmail.error="email required"
            error=true
        }
        if (password.isBlank()){
            binding.tilPassword.error="password required"
            error=true
        }
//        if (!error){
//            startActivity(Intent(this,Landingpage_activity::class.java))
//        }
    }
}