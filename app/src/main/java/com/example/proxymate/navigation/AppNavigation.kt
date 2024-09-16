package com.example.proxymate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proxymate.ui.AttendancePageDisplay
import com.example.proxymate.ui.SplashScreenDisplay

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreenDisplay{
                navController.navigate("attendance_screen")
            }
        }
        composable("attendance_screen") {
            AttendancePageDisplay()
        }
    }
}
