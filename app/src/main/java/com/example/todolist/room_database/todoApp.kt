package com.example.todolist.room_database

import android.app.Application
import com.example.todolist.room_gtask.GtaskDatabase

class todoApp: Application() {
    val db by lazy {
        todoDatabase.getInstance(this)
    }
    val Gtaskdb by lazy {
        GtaskDatabase.getInstance(this)
    }
}