package com.example.taskapp.phase2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)

@Composable
fun TaskList(){
    val tasks = remember{mutableStateListOf(
        Task(1, "Task 1", "Description for Task 1", false),
        Task(2, "Task 2", "Description for Task 2", true),
        Task(3, "Task 3", "Description for Task 3", false)
    )}
//    tasks.add(Task(1, "Task 1", "Description for Task 1", false))
     LazyColumn (
         modifier = Modifier.fillMaxWidth().background(Color.LightGray),


     ){
         items(tasks){ tasks->
             ElevatedCard(
                 modifier = Modifier.fillMaxWidth().padding(8.dp),\

             ) { }
             Text(text = tasks.title)
             Text(text = tasks.description)
         }
     }
}

@Preview(showBackground = true)
@Composable
fun TaskListPreview() {

    TaskList()

}
