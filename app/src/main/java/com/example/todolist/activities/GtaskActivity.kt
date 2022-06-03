package com.example.todolist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.R
import com.example.todolist.databinding.ActivityGtaskBinding

class GtaskActivity : AppCompatActivity() {
    private var binding: ActivityGtaskBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGtaskBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.bottomNavigation?.selectedItemId = R.id.gtask
        navigationThroughActivities()
        setupActionBar()
    }
    private fun setupActionBar() {
        setSupportActionBar(binding?.toolbarGtaskActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back_indicator)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding?.toolbarGtaskActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
    }
    private fun navigationThroughActivities(){
        binding?.bottomNavigation?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.graph -> {
                    startActivity(Intent(this, GraphActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.goal -> {
                    startActivity(Intent(this, GoalActivity::class.java))
                    overridePendingTransition(0,0,)
                }
                R.id.gtask -> {

                }
            }
            true
        }
    }
}