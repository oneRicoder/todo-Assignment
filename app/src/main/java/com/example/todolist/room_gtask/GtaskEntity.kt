package com.example.todolist.room_gtask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gtask_table")
data class GtaskEntity (
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "task_name") val task_name: String = "",
    @ColumnInfo(name = "category_list")  val category_list: ArrayList<String> = ArrayList()
)