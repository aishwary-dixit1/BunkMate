package com.example.proxymate.database

import android.content.Context
import androidx.room.Room

object Graph {
    lateinit var database: SubjectDatabase

    val subjectRepository by lazy{
        SubjectRepository(subjectDao = database.subjectDao())
    }

    fun provide(context : Context){
        database = Room.databaseBuilder(context, SubjectDatabase::class.java, "subjectList.db").build()
    }
}