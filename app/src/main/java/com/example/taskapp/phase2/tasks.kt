package com.example.taskapp.phase2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
fun TaskList(taskList: List<Task>, onTaskCheckedChange: (Task, Boolean) -> Unit){
//    val taskList = remember{mutableStateListOf(
//        Task(1, "Task 1", "Description for Task 1", false),
//        Task(2, "Task 2", "Description for Task 2", false),
//        Task(3, "Task 3", "Description for Task 3", false),
//        Task(4, "Task 4", "Description for Task 4", false),
//        Task(5, "Task 5", "Description for Task 5", false),
//        Task(6, "Task 6", "Description for Task 6", false),
//    )}
////    tasks.add(Task(1, "Task 1", "Description for Task 1", false))
     LazyColumn (
         modifier = Modifier.fillMaxWidth(),


     ){
         items(taskList, key = {it.id}){ task->
             ElevatedCard(
                 modifier = Modifier.fillMaxWidth().padding(8.dp),
                 elevation = CardDefaults.cardElevation(4.dp),
                 colors = CardDefaults.elevatedCardColors(
                     containerColor = if (task.isCompleted) Color.DarkGray else Color.Unspecified
                 )
             ) {
                 Column (modifier = Modifier.padding(10.dp)){

                 Row(
                     modifier = Modifier.fillMaxWidth(),
                     horizontalArrangement = Arrangement.End,
                     verticalAlignment = Alignment.CenterVertically
                 ) {
                     Column (modifier = Modifier.weight(1f),
                         verticalArrangement = Arrangement.SpaceBetween,
                         horizontalAlignment = Alignment.Start) {
                         Text(text = task.title)
                         Text(text = task.description)
                     }


                     Checkbox(
                         checked = task.isCompleted,
                         onCheckedChange = { isChecked ->
                               onTaskCheckedChange(task,isChecked)
                             },

//                                 colors = androidx.compose.material3.CheckboxDefaults.colors(
//                                 checkedColor = if (task.isCompleted) Color.Green else Color.Gray
//                                 )
                     )
                         }
                     }
                 }
             }
         }
     } // lazy



//@Preview(showBackground = true)
//@Composable
//fun TaskListPreview() {
//
//    TaskList()
//
//}
