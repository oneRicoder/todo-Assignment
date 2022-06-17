package com.example.todolist.room_gtask

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [GtaskEntity::class], version = 1)
@TypeConverters(CategoryListTypeConverter::class)
abstract class GtaskDatabase: RoomDatabase() {
    abstract fun GtaskDao(): GtaskDao

    companion object{
        @Volatile
        private var INSTANCE: GtaskDatabase? = null

        fun getInstance(context: Context): GtaskDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext, GtaskDatabase::class.java, "gtask_table").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}