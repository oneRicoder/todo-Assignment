package com.example.todolist.room_gtask

import androidx.room.*
import com.example.todolist.room_database.todoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GtaskDao {
    @Insert
    suspend fun insert(GtaskEntity: GtaskEntity)

    @Update
    suspend fun update(GtaskEntity: GtaskEntity)

    @Delete
    suspend fun delete(GtaskEntity: GtaskEntity)

    @Query("SELECT * FROM `gtask_table`")
    fun fetchAllTodo(): Flow<List<GtaskEntity>>

    @Query("SELECT * FROM `gtask_table` where uid=:id")
    fun fetchById(id:Int): Flow<GtaskEntity>
}