package com.test.week01_00.data.repositoryimpl

import com.test.week01_00.data.dao.TaskDao
import com.test.week01_00.data.model.Task
import com.test.week01_00.domain.repository.TaskRepository

class TaskRepositoryImpl(val dao: TaskDao) : TaskRepository {
    override suspend fun insert(task: Task) {
        dao.insert(task)
    }

    override fun delete(task: Task) {
        dao.delete(task)

    }

    override fun update(task: Task) {
//        dao.update(task)

    }

    override suspend fun getAll(): List<Task> =
        dao.getAll()

}