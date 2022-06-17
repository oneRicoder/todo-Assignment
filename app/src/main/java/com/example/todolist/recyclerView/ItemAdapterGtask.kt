package com.example.todolist.recyclerView

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.room_database.todoEntity
import com.example.todolist.room_gtask.GtaskEntity
import kotlinx.android.synthetic.main.activity_add_gtask.view.*
import kotlinx.android.synthetic.main.category_item_row.view.*
import kotlinx.android.synthetic.main.gtask_item_row.view.*
import kotlinx.android.synthetic.main.item_row.view.*

class ItemAdapterGtask(val context: Context, val list: ArrayList<GtaskEntity>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.gtask_item_row, parent, false))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //Log.i("hshkfhskjdhfsk",list.toString())
        val model = list[position]
        if (holder is MyViewHolder){
            holder.itemView.title_itemView_gtask.text = model.task_name
            holder.itemView.rv_gtask_itemView.layoutManager = LinearLayoutManager(context)
            holder.itemView.rv_gtask_itemView.adapter = GtaskListRvItemAdapter(context, model.category_list)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}