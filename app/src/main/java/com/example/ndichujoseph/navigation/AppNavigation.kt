package com.example.ndichujoseph.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ndichujoseph.HomePage
import com.example.ndichujoseph.screens.AddScreen
import com.example.ndichujoseph.screens.Dashboard
import com.example.ndichujoseph.screens.LoginPage
import com.example.ndichujoseph.screens.Register
import com.example.ndichujoseph.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "SplashScreen"
    ) {
        composable("LoginPage") { LoginPage(navController) }
        composable("Dashboard") { Dashboard(navController) }
        composable("AddScreen") { AddScreen(navController) }
        composable("Register") { Register(navController) }
        composable("HomePage") { HomePage(navController) }
        composable("SplashScreen") { SplashScreen(navController) }
    }
}
