package com.example.proxymate.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proxymate.navigation.MyAppNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProxyMateTheme {
                    Surface(modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black)
                        .padding(0.dp)
                    ) {
                        MyAppNavigation()
                    }
            }
        }
    }
}
@Composable
fun MyApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first_screen"){
        composable("first_screen"){
            SplashScreenDisplay(){
                navController.navigate("second_screen")
            }
        }
        composable("second_screen"){
            AttendancePageDisplay()
        }
    }
}

