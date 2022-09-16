package com.yugi.elegance_gym.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yugi.elegance_gym.ApiClient
import com.yugi.elegance_gym.ApiInterface
import com.yugi.elegance_gym.databinding.ActivitySignUpBinding
import com.yugi.elegance_gym.models.RegisterRequest

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
        null.also { binding.tilEmail1.error = it }
        binding.tilPassword.error=null
        val Firstname=binding.etFirstname.text.toString()
        val Lastname= binding.etLastname .text.toString()
        val Email=binding.etEmail1.text.toString()
        val Password=binding.etPassword1.text.toString()
        val Reenter=binding.etReenter.text.toString()

        var error=false

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

       if (!error){
           var registerRequest=RegisterRequest(Firstname,Lastname,Email,Password,Phonenumber)
           makeRegistrationREquest(registerRequest)
       }


    }

open class AppCompatActivity



