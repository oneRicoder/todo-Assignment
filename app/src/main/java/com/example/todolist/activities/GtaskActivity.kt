package com.example.todolist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.todolist.R
import com.example.todolist.databinding.ActivityGtaskBinding
import com.example.todolist.recyclerView.ItemAdapterGtask
import com.example.todolist.room_database.todoApp
import com.example.todolist.room_gtask.GtaskDao
import com.example.todolist.room_gtask.GtaskEntity
import kotlinx.coroutines.launch

class GtaskActivity : AppCompatActivity() {
    private var binding: ActivityGtaskBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGtaskBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.bottomNavigation?.selectedItemId = R.id.gtask
        navigationThroughActivities()
        setupActionBar()
        binding?.addGtaskBtn?.setOnClickListener {
            startActivity(Intent(this, AddGtaskActivity::class.java))
        }
        val GtaskDao = (application as todoApp).Gtaskdb.GtaskDao()
        lifecycleScope.launch {
            GtaskDao.fetchAll().collect{
                populateGtaskToUI(ArrayList(it))
            }
        }
    }

    private fun populateGtaskToUI(GtaskList: ArrayList<GtaskEntity>) {
        if (GtaskList.isNotEmpty()){
            binding?.rvGtask?.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            val adapter = ItemAdapterGtask(this, GtaskList)
            binding?.rvGtask?.adapter = adapter
        }
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