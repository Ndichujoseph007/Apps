package com.example.ndichujoseph.navigation

import CatalogScreen
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ndichujoseph.HomePage
import com.example.ndichujoseph.ViewModel.AuthViewModel
import com.example.ndichujoseph.screens.AddScreen
import com.example.ndichujoseph.screens.Dashboard
import com.example.ndichujoseph.screens.LoginPage
import com.example.ndichujoseph.screens.Register
import com.example.ndichujoseph.screens.CatalogScreen
import com.example.ndichujoseph.screens.SplashScreen

// Object to hold navigation routes as constants
object AppScreens {
    const val SplashScreen = "SplashScreen"
    const val LoginPage = "LoginPage"
    const val Dashboard = "Dashboard"
    const val AddScreen = "AddScreen"
    const val Register = "Register"
    const val HomePage = "HomePage"
    const val CatalogScreen = "CatalogScreen"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel() // Correctly uses viewModel()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen // Uses the SplashScreen constant
    ) {
        composable(AppScreens.LoginPage) { LoginPage(navController) } // Uses the LoginPage constant
        composable(AppScreens.Dashboard) { Dashboard(navController) }
        composable(AppScreens.AddScreen) { AddScreen(navController) }
        composable(AppScreens.Register) { Register(navController, authViewModel) }
        composable(AppScreens.HomePage) { HomePage(navController) }
        composable(AppScreens.CatalogScreen) { CatalogScreen(navController) }
        composable(AppScreens.SplashScreen) { SplashScreen(navController) }
    }
}