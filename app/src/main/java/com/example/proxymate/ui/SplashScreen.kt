package com.example.proxymate.ui

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.rememberGraphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreenDisplay(onNavigateToAttendanceScreen: () -> Unit) {
    var isComplete by remember {
        mutableStateOf(false)
    }
    var progress by remember { mutableStateOf(0f) }
    val scope = rememberCoroutineScope()

//    scope.launch {
//        for (i in 0..11) {
//            delay(15)
//            progress = (i*10) / 100f
//            if (i > 10) {
//                onNavigateToAttendanceScreen()
//                break
//            }
//
//        }
//    }
    LaunchedEffect(Unit) {
        progress = 1f
    }



    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 5000)
    )
    if(animatedProgress >= 1f){
        onNavigateToAttendanceScreen()
    }
    val progressBarColor = when {
        animatedProgress < 0.5 -> Color.Red
        animatedProgress < 0.75 -> Color.Green
        else -> Color.Green
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .width(250.dp)
            .background(Color.Black)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier.size(200.dp),
            color = progressBarColor,
            strokeWidth = 8.dp,
            strokeCap = StrokeCap.Round
        )
        Text(
            text = "%",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 75.sp
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.Black)
        )
    }
    Text(
        text = "Bunk Mate",
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 50.sp
        )
    )
//        Spacer(modifier = Modifier.height(150.dp))
//        OutlinedButton(onClick = {onNavigateToAttendanceScreen()}) {
//            Text(text = "Lets mark our attendance",
//                style = MaterialTheme.typography.headlineSmall.copy(color = Color.White))
//        }
}
}

@Preview
@Composable
fun PreviewSplashScreenDisplay(){
    SplashScreenDisplay {}
}