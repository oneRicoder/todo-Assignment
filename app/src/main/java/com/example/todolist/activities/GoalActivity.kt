package com.example.todolist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.R
import com.example.todolist.databinding.ActivityGoalBinding

class GoalActivity : AppCompatActivity() {
    private var binding: ActivityGoalBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoalBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.bottomNavigation?.selectedItemId = R.id.goal

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
                    startActivity(Intent(this, GraphActivity::class.java))
                    overridePendingTransition(0,0,)
                }
                R.id.goal -> {

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