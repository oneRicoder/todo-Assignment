package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.todolist.databinding.ActivityEditTaskBinding
import com.example.todolist.room_database.todoApp
import com.example.todolist.room_database.todoDao
import com.example.todolist.room_database.todoEntity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class EditTaskActivity : AppCompatActivity() {
    var binding: ActivityEditTaskBinding? = null
    private var position: Int = 0
    lateinit var model: ArrayList<todoEntity>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTaskBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupActionBar()
        val todoDao = (application as todoApp).db.todoDao()
        if (intent.hasExtra("position")){
            position = intent.getIntExtra("position", 0)
        }
        lifecycleScope.launch {
            todoDao.fetchAllTodo().collect{
                setUpData(ArrayList(it), position)
                model = ArrayList(it)
            }
        }
        binding?.increase?.setOnClickListener {
            increaseInitialValue(position)
        }
        binding?.deleteTask?.setOnClickListener {
            deleteTask(position)
        }
        binding?.decrease?.setOnClickListener {
            decreaseInitialValue()
        }

    }
    private fun increaseInitialValue(position: Int){
        val todoDao = (application as todoApp).db.todoDao()
        Toast.makeText(this, "increased", Toast.LENGTH_SHORT).show()
    }
    private fun deleteTask(position: Int){
        val todoDao = (application as todoApp).db.todoDao()
        if (model.size > 0){
            var todoEntity: todoEntity = model[position]
            Log.i("kdkdkshsk",position.toString())
            lifecycleScope.launch {
                todoDao.delete(todoEntity)
                finish()
            }
        }
        Toast.makeText(this, "deleted", Toast.LENGTH_SHORT).show()
    }
    private fun decreaseInitialValue(){
        Toast.makeText(this, "decreased", Toast.LENGTH_SHORT).show()
    }
    private fun setUpData(model: ArrayList<todoEntity>, position: Int){
        if (model.size > 0 && position < model.size){
            val todoItem = model[position]
            binding?.editTaskName?.text = todoItem.task_name
            binding?.editProgressText?.text = "${todoItem.initial_value}/${todoItem.final_value}"
            binding?.EditprogressBar?.max = todoItem.final_value
            binding?.EditprogressBar?.progress = todoItem.initial_value
        }
    }
    private fun setupActionBar() {
        setSupportActionBar(binding?.toolbarEditTaskActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back_indicator)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding?.toolbarEditTaskActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}