package com.test.week01_00.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.test.week01_00.data.model.Task

interface TaskRepository {

    suspend fun insert(task: Task)

    fun delete(task: Task)

    fun update(task: Task)

    suspend fun getAll(): List<Task>
}