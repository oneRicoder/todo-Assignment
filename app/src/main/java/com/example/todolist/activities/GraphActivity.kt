package com.example.todolist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.R
import com.example.todolist.databinding.ActivityGraphBinding

class GraphActivity : AppCompatActivity() {
    private var binding: ActivityGraphBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGraphBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        navigationThroughActivities()
    }

    private fun navigationThroughActivities(){
        binding?.bottomNavigation?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0,0)
                }
                R.id.graph -> {

                }
                R.id.goal -> {
                    startActivity(Intent(this, GoalActivity::class.java))
                    overridePendingTransition(0,0,)
                }
                R.id.gtask -> {
                    startActivity(Intent(this, GtaskActivity::class.java))
                    overridePendingTransition(0,0)
                }
            }
            true
        }
    }
}