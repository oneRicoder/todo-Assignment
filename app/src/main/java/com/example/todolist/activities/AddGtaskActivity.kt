package com.example.todolist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.R
import com.example.todolist.databinding.ActivityAddGtaskBinding
import com.example.todolist.databinding.ActivityGtaskBinding
import com.example.todolist.recyclerView.CategoryItemAdapter
import com.example.todolist.room_database.todoApp
import com.example.todolist.room_gtask.GtaskDao
import com.example.todolist.room_gtask.GtaskEntity
import kotlinx.coroutines.launch

class AddGtaskActivity : AppCompatActivity() {
    private var binding: ActivityAddGtaskBinding? = null
    private val CategoryItemsArraylist: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddGtaskBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupActionBar()
        val gtaskdao = (application as todoApp).Gtaskdb.GtaskDao()
        binding?.plusBtnForCategoryItem?.setOnClickListener {
            addItemToCategory()
        }
        binding?.saveBtnGtaskActivity?.setOnClickListener {
            lifecycleScope.launch {
                saveDataToRoom(gtaskdao)
            }
        }
    }

    private fun saveDataToRoom(gtaskDao: GtaskDao) {
        val task_name = binding?.etTaskName?.text.toString()
        if (task_name.isEmpty()){
            Toast.makeText(this, "Please Enter Task Name!", Toast.LENGTH_SHORT).show()
        }else if(CategoryItemsArraylist.isEmpty()){
            Toast.makeText(this, "Please Enter Category Items!", Toast.LENGTH_SHORT).show()
        } else{
            lifecycleScope.launch {
                gtaskDao.insert(GtaskEntity(task_name = task_name, category_list = CategoryItemsArraylist))
                Toast.makeText(this@AddGtaskActivity, "Data Saved Successfully!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addItemToCategory() {
        val categoryItem = binding?.etCategoryItem?.text.toString()
        if (categoryItem.isEmpty()){
            Toast.makeText(this, "Please Enter Category Name!", Toast.LENGTH_SHORT).show()
        }else{
            binding?.rvCategory?.visibility = View.VISIBLE
            CategoryItemsArraylist.add(categoryItem)
            binding?.rvCategory?.layoutManager = LinearLayoutManager(this)
            binding?.rvCategory?.adapter = CategoryItemAdapter(this, CategoryItemsArraylist)
            binding?.etCategoryItem?.setText("")
        }
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