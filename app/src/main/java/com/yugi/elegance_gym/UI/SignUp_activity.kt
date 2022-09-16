package com.yugi.elegance_gym.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.yugi.elegance_gym.databinding.ActivitySignUpBinding
import com.yugi.elegance_gym.models.RegisterResponse
import com.yugi.elegance_gym.Api.ApiClient
import com.yugi.elegance_gym.Api.ApiInterface
import com.yugi.elegance_gym.ViewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.yugi.elegance_gym.models.RegisterRequest as RegisterRequest1

val Unit.enqueue: Unit
    get() {}

class SignUp_activity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    val userViewModel:UserViewModel by viewModels()
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

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer { registerResponse ->
            Toast.makeText(baseContext,registerResponse?.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,LoginActivity::class.java))
        })

        userViewModel.registerErrorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
    fun validateSignup1(){
        var error =false
        null.also { binding.tilEmail1.error = it }
        binding.tilPassword.error=null
        val Firstname=binding.etFirstname.text.toString()
        val Lastname= binding.etLastname .text.toString()
        val Email=binding.etEmail1.text.toString()
        val Password=binding.etPassword1.text.toString()
        val Reenter=binding.etReenter.text.toString()
        val Phonenumber=binding.tilPhoneNumber.toString()


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
           var registerRequest= RegisterRequest1(Firstname,Lastname,Email,Password,Phonenumber)
           userViewModel.registerUser(registerRequest)
       }
    }

    }



open class AppCompatActivity



