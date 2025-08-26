//package com.example.taskapp.phase3
//
//import androidx.compose.runtime.mutableStateListOf
//import androidx.lifecycle.ViewModel
//import com.example.taskapp.phase2.Task
//
//class TaskViewModel: ViewModel() {
//    private val _taskList = mutableStateListOf<Task>()
//    val tasklist: List<Task> get() = _taskList
//
//    fun addTask(title: String, description: String){
//        val newTask = Task(
//            id = _taskList.size + 1,
//            title = title,
//            description = description,
//            isCompleted = false
//        )
//        _taskList.add(newTask)
//    }
//    fun updateTask(updatedTask: Task, isCompleted: Boolean) {
//        val index = _taskList.indexOfFirst { it.id == updatedTask.id }
//        if (index != -1) {
//            _taskList[index] = updatedTask.copy(isCompleted = isCompleted)
//        }
//    }
//}
//
