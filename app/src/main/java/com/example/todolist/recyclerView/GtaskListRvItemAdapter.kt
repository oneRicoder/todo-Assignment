package com.example.todolist.recyclerView

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.room_database.todoEntity
import kotlinx.android.synthetic.main.item_row.view.*
import kotlinx.android.synthetic.main.item_row_gtask_item_row_rv.view.*

class GtaskListRvItemAdapter(val context: Context, val list: ArrayList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row_gtask_item_row_rv, parent, false))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val string = list[position]
        if (holder is MyViewHolder){
            //holder.itemView.civ_gtask_taskList.setBackgroundColor(Color.parseColor("#023047"))
            holder.itemView.rv_tv_item_row_gtask.text = string
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }
}