package com.example.taskapp.phase3

sealed class Screen(val route: String) {
    object Drawer : Screen("drawer")
    object DailyGoals : Screen("dailygoals")
    object CompletedTasks : Screen("completedTasks")
    object Streak : Screen("streak")
    object About : Screen("about")
}
