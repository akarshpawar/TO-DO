package com.test.week01_00.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val taskId: Long = 0L,
    val taskTitle: String,
    val taskDescription: String,
    val priority: String? = null
)