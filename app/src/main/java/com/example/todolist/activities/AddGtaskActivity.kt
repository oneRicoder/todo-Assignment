package com.example.todolist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.R
import com.example.todolist.databinding.ActivityAddGtaskBinding
import com.example.todolist.databinding.ActivityGtaskBinding

class AddGtaskActivity : AppCompatActivity() {
    private var binding: ActivityAddGtaskBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddGtaskBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupActionBar()
    }
    private fun setupActionBar() {
        setSupportActionBar(binding?.toolbarAddGtaskActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back_indicator)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding?.toolbarAddGtaskActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}