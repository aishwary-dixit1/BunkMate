package com.example.proxymate.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Subject::class],
    version = 1,
    exportSchema = false
)
    abstract class SubjectDatabase : RoomDatabase(){
        abstract fun subjectDao(): SubjectDAO
    }
