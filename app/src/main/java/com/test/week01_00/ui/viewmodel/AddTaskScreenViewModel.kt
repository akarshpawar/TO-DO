package com.test.week01_00.ui.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.week01_00.data.model.Task
import com.test.week01_00.data.repositoryimpl.TaskRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AddTaskScreenViewModel(val repositoryImpl: TaskRepositoryImpl) :
    ViewModel() {
    var taskTitle = mutableStateOf("")
        private set
    var taskDescription = mutableStateOf("")
        private set


    fun onTitleChanged(newText: String) {
        taskTitle.value = newText
    }

    fun onDescriptionChanged(newText: String) {
        taskDescription.value = newText
    }

    fun insert() {
        CoroutineScope(IO).launch {
            repositoryImpl.insert(Task(taskTitle = "Have Breakfast", taskDescription = "Healthy Meal"))

        }
    }
}


class AddTaskScreenViewModelFactory(
    private val repositoryImpl: TaskRepositoryImpl
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddTaskScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddTaskScreenViewModel(repositoryImpl) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}