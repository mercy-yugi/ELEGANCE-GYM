package com.yugi.elegance_gym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import com.yugi.elegance_gym.databinding.ActivityLoginBinding
import com.yugi.elegance_gym.databinding.ActivitySignUpBinding

class SignUp_activity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSignUp1.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp1.setOnClickListener {
            validateSignup1()
        }
    }
    fun validateSignup1(){
        var error=false
        binding.tilEmail1.error=null
        binding.tilPassword.error=null
        val Firstname=binding.etFirstname.text.toString()
        val Lastname= binding.etLastname .text.toString()
        val Email=binding.etEmail1.text.toString()
        val Password=binding.etPassword1.text.toString()
        val Reenter=binding.etReenter.text.toString()
        if (Firstname.isBlank()){
            binding.tilFirstname.error="firstname is required"
            error=true}

        if (Lastname.isBlank()){
            binding.tilLastname.error="Lastname is required"
            error=true
        }
        if (Email.isBlank()){
            binding.tilEmail1.error="Email is required"
            error=true
        }
        if (Password.isBlank()){
            binding.tilPassword.error="Password is required"
            error=true
        }
        if (Reenter.isBlank()){
            binding.tilReenter.error="PasswordConfirmation is required"
            error=true
        }

        when {
            !error -> {

            }
        }
    }

    }

