package com.yugi.elegance_gym.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.yugi.elegance_gym.databinding.ActivityLoginBinding
import com.yugi.elegance_gym.models.LoginRequest
import com.yugi.elegance_gym.models.LoginResponse
import com.yugi.elegance_gym.Api.ApiClient
import com.yugi.elegance_gym.Api.ApiInterface
import com.yugi.elegance_gym.ViewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
  lateinit var binding: ActivityLoginBinding
  lateinit var sharedPrefs:SharedPreferences
  val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs=getSharedPreferences("ELEGANCE-GYM_PREFS", MODE_PRIVATE)
        binding.btnLogin1.setOnClickListener {
            checkLogin()

        }

        binding.tvSign.setOnClickListener {
            val intent = Intent(this, SignUp_activity::class.java)
            startActivity(intent)
        }

    }
    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this) { LoginResponse ->
            saveLoginDetails(LoginResponse!!)
            Toast.makeText(baseContext, LoginResponse?.message, Toast.LENGTH_LONG)
            startActivity(Intent(baseContext, Landingpage_activity::class.java))
            finish()
        }
        userViewModel.loginErrorLiveData.observe(this, Observer { error ->

            Toast.makeText(baseContext, error,Toast.LENGTH_LONG).show()

        })
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
        if (!error){
            var loginRequest= LoginRequest(email,password)
            binding.pbbar.visibility= View.GONE
          userViewModel.loginUser(loginRequest)
        }
    }

    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor=sharedPrefs.edit()
        editor.putString("ACCESS_TOKEN",loginResponse.access_token)
        editor.putString("PROFILE_ID",loginResponse.profile_id)
        editor.putString("USER_ID",loginResponse.user_id)
        editor.apply()
    }

    fun Unit.enqueue(callback: Callback<LoginResponse>) {

    }

}
