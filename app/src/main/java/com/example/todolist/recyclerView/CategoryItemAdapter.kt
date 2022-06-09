package com.example.todolist.recyclerView

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.room_database.todoEntity
import kotlinx.android.synthetic.main.activity_add_gtask.view.*
import kotlinx.android.synthetic.main.category_item_row.view.*
import kotlinx.android.synthetic.main.item_row.view.*

class CategoryItemAdapter(val context: Context, val list: ArrayList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.category_item_row, parent, false))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.i("hshkfhskjdhfsk",list.toString())
        holder.itemView.tv_category_item_row.text = list[position]

    }

    override fun getItemCount(): Int {
        return list.size
    }
}