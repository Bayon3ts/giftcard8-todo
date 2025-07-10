package com.example.todoproject.navigation  // 🔑 FIXED: Package name should match folder

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todoproject.login.LoginScreen  // 🔑 FIX: Match actual package paths
import com.example.todoproject.register.RegisterScreen
import com.example.todoproject.task.TaskScreen

object Routes {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val TASKS = "tasks"
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.LOGIN) {
        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }
        composable(Routes.REGISTER) {
            RegisterScreen(navController)
        }
        composable(Routes.TASKS) {
            TaskScreen(navController)
        }
    }
}
