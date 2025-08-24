package com.example.taskapp.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskapp.phase2.Task
import com.example.taskapp.phase2.TaskList
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskAppDrawer(

) {

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed//?
    )
    // list of tasks
    var tasklist by remember { mutableStateOf(listOf<Task>()) }
    // dialog state
    var showDialog by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope() //?
    //input fields
    var presses by remember { mutableIntStateOf(0) }
    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .verticalScroll(
                            rememberScrollState()
                        )
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Profile Icon",
                        modifier = Modifier.padding(16.dp)
                    )
                    HorizontalDivider()
                }
                NavigationDrawerItem(
                    label = {
                        Text("Daily goals")
                    },
                    selected = false,
                    onClick = {}
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = {
                        Text("Completed tasks")
                    },
                    selected = false,
                    onClick = {}
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = {
                        Text("Calendar")
                    },
                    selected = false,
                    onClick = {}
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = {
                        Text("Settings")
                    },
                    selected = false,
                    onClick = {}
                )
            }
        },
        drawerState = drawerState // ?
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                        scrolledContainerColor = MaterialTheme.colorScheme.primary,
                        navigationIconContentColor = MaterialTheme.colorScheme.primary,
                        actionIconContentColor = MaterialTheme.colorScheme.primary),
                    title = { Text("Task App", color = Color.Black) },
                    navigationIcon = {

                        IconButton(
                            onClick = {
                                scope.launch {
                                    if (drawerState.isClosed) {
                                        drawerState.open()
                                    } else {
                                        drawerState.close()
                                    }
                                }
                            }
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu Icon", tint = Color.Black)
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Functions",
                        color = Color.Black
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {showDialog = true}) {
                    Icon(Icons.Default.Add, contentDescription = "Add Task")
                }
                }
        ) { innerpadding ->
            Column(
                modifier = Modifier.padding(innerpadding),

                ) {
                TaskList(
                    taskList = tasklist,
                    onTaskCheckedChange = { updatedTask, isChecked ->
                        // Update your list here
                        tasklist = tasklist.map {
                            if (it.id == updatedTask.id) it.copy(isCompleted = isChecked) else it
                        }
                    }
                )
            }
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Add Task") },
                    text = {
                        Column {
                            OutlinedTextField(
                                value = taskTitle,
                                onValueChange = { taskTitle = it },
                                label = { Text("Title") },
                                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                            )
                            OutlinedTextField(
                                value = taskDescription,
                                onValueChange = { taskDescription = it },
                                label = { Text("Description") },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                if (taskTitle.isNotBlank()) {
                                    val newTask = Task(
                                        id = tasklist.size + 1,
                                        title = taskTitle,
                                        description = taskDescription,
                                        isCompleted = false
                                    )
                                    tasklist = tasklist + newTask
                                    taskTitle = ""
                                    taskDescription = ""
                                    showDialog = false
                                }
                            }
                        ) {
                            Text("Add")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }

                    }


        }
    }


@Preview(showBackground = true)
@Composable
fun TaskAppDrawerPreview() {
    TaskAppDrawer()
}