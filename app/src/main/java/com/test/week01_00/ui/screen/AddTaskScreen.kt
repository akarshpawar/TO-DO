package com.test.week01_00.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.week01_00.AppDatabase
import com.test.week01_00.data.repositoryimpl.TaskRepositoryImpl
import com.test.week01_00.ui.viewmodel.AddTaskScreenViewModel
import com.test.week01_00.ui.viewmodel.AddTaskScreenViewModelFactory


@Preview(showSystemUi = true)
@Composable
fun PreviewEnterTaskScreen() {
    EnterTaskScreen()
}

@Composable
fun EnterTaskScreen() {
    val context = LocalContext.current

    val repository = TaskRepositoryImpl(
        AppDatabase.getInstance(context).taskDao()
    )
    val factory = AddTaskScreenViewModelFactory(repository)

    val viewModel: AddTaskScreenViewModel = viewModel(factory = factory)
    val textTitle by viewModel.taskTitle
    val taskDescription by viewModel.taskDescription

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(modifier = Modifier.fillMaxWidth(),
                value = textTitle,
                onValueChange = { newText ->
                    // Update the ViewModel when text changes
                    viewModel.onTitleChanged(newText)
                },
                label = { Text("Enter Task Title") }
            )
            TextField(modifier = Modifier.fillMaxWidth(),
                value = taskDescription,
                onValueChange = { newText ->
                    // Update the ViewModel when text changes
                    viewModel.onDescriptionChanged(newText)
                },
                label = { Text("Enter Task Description") }
            )
            Button(onClick = {
                viewModel.insert()
            }) {
                Text(text = "Submit Task", color = Color.White)
            }
        }

    }
}