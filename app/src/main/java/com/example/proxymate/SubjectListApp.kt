package com.example.proxymate

import android.app.Application
import androidx.compose.ui.graphics.vector.Group
import com.example.proxymate.database.Graph

class SubjectListApp : Application() {
    override fun onCreate(){
        super.onCreate()
        Graph.provide(this)
    }
}