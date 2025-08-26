package com.example.taskapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskapp.home.About
import com.example.taskapp.home.TaskAppDrawer
//import com.example.taskapp.pages.About
import com.example.taskapp.pages.CompletedTasks
import com.example.taskapp.pages.DailyGoals
import com.example.taskapp.pages.Streak
import com.example.taskapp.phase3.Screen
//import com.example.taskapp.home.TaskAppDrawer
//import com.example.taskapp.home.TaskAppScafold
import com.example.taskapp.ui.theme.TaskAppTheme
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskAppTheme {
//                TaskAppDrawer()
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Drawer.route
                ){
                    composable(Screen.Drawer.route){
                        TaskAppDrawer(navController = navController)
                    }
//                    composable(Screen.DailyGoals.route){
//                        DailyGoals(nav)
//                    }
                    composable(Screen.CompletedTasks.route){
                        CompletedTasks()
                    }
                    composable(Screen.Streak.route){
                        Streak()
                    }
                    composable(Screen.About.route){
                        About(navController = navController)
                    }
                }
                }
            }
        }
    }

