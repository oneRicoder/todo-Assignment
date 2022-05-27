package com.example.todolist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.todolist.R
import com.example.todolist.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    var binding: ActivitySignUpBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar()
        binding?.btnSignUp?.setOnClickListener {
            registerUser()
        }
    }
    private fun registerUser(){
        val name: String = binding?.etName?.text.toString().trim { it <= ' ' }
        val email: String = binding?.etEmail?.text.toString().trim { it <= ' ' }
        val password: String = binding?.etPassword?.text.toString().trim { it <= ' ' }
        if (validateForm(name, email, password)){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    private fun validateForm(name: String, email: String, password: String): Boolean{
        return when{
            TextUtils.isEmpty(name) -> {
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this, "Please Enter Your Email Address", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(password) -> {
                Toast.makeText(this, "Please Enter Your Password", Toast.LENGTH_SHORT).show()
                false
            }else -> {
                true
            }
        }
    }
    private fun setSupportActionBar(){
        setSupportActionBar(toolbar_sign_up_activity)
        val actionBar = supportActionBar
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        }
        toolbar_sign_up_activity.setNavigationOnClickListener {
            onBackPressed()
        }
    }

}