package com.example.proxymate.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AttendancePageDisplay() {
    var showDailog by remember{
        mutableStateOf(false)
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDailog = true}) {
                Icon(
                    imageVector = Icons.Filled.Add, contentDescription = "Add"
                )
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .padding(0.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(color = Color.Black)
            ) {
                items(items = mockCardDetails) { subject ->
                    AttendanceCard(subjectDetails = subject)

                }
            }
            if(showDailog){
                AddNewSubjectDailog(showDailog = showDailog)
            }
        }
    }
}