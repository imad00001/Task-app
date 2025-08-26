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
import androidx.navigation.NavController
import com.example.taskapp.pages.DailyGoals
import com.example.taskapp.phase2.Task
import com.example.taskapp.phase2.TaskList
import com.example.taskapp.phase3.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun About(
    navController: NavController
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
                    onClick = {
                        scope.launch { drawerState.close() } // close drawer
                        navController.navigate(Screen.Drawer.route)
                    }
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = {
                        Text("Completed tasks")
                    },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() } // close drawer
                        navController.navigate(Screen.CompletedTasks.route)
                    }
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = {
                        Text("Streak")
                    },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() } // close drawer
                        navController.navigate(Screen.Streak.route)
                    }
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = {
                        Text("About")
                    },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() } // close drawer
                        navController.navigate(Screen.About.route)
                    }
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
                    title = { Text("About us", color = Color.Black) },
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

        ) { innerpadding ->
            Column(
                modifier = Modifier
                    .padding(innerpadding)
                    .fillMaxSize()
                    .background(Color.Unspecified)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                //  horizontalAlignment = Alignment.CenterHorizontally,
                // verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "About Us",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Welcome to our Task Management App! We are dedicated to helping you stay organized and productive by providing a simple and efficient way to manage your daily tasks. Our app is designed with user-friendliness in mind, ensuring that you can easily add, track, and complete your tasks with just a few taps.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Our team is passionate about creating tools that enhance your productivity and simplify your life. We believe that staying organized should be effortless, and our app is here to support you every step of the way.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Thank you for choosing our Task Management App. We are committed to continuously improving our app and providing you with the best experience possible. If you have any feedback or suggestions, please don't hesitate to reach out to us.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Happy task managing!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "The TaskApp Team",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }


    }
}


