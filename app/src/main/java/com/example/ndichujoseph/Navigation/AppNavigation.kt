package com.example.ndichujoseph.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ndichujoseph.HomePage
import com.example.ndichujoseph.Screens.AddScreen
import com.example.ndichujoseph.Screens.Dashboard
import com.example.ndichujoseph.Screens.LoginPage
import com.example.ndichujoseph.Screens.Register

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "HomePage"
    ) {
        composable("LoginPage") { LoginPage(navController) }
        composable("Dashboard") { Dashboard(navController) }
        composable("AddScreen") { AddScreen(navController) }
        composable("Register") { Register(navController) }
        composable("HomePage") { HomePage(navController) }
    }
}
