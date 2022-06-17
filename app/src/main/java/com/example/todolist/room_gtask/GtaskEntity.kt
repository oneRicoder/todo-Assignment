package com.example.todolist.room_gtask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "gtask_table")
data class GtaskEntity (
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "task_name") val task_name: String = "",
    @ColumnInfo(name = "category_list")  val category_list: ArrayList<String> = ArrayList()
)

class CategoryListTypeConverter{
    @TypeConverter
    fun fromString(value: String?): ArrayList<String>{
        val listType = object : TypeToken<ArrayList<String>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String>): String{
        return Gson().toJson(list)
    }
}