package com.test.week01_00.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.test.week01_00.data.model.Task

@Dao
interface TaskDao {

    @Insert
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)

//    @Update
//    suspend fun updateTask(task: Task)

    @Query("select * from Task")
    suspend fun getAll(): List<Task>
}