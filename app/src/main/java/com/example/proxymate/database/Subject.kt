package com.example.proxymate.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "subject-table")
data class Subject(
    @PrimaryKey (autoGenerate = true)
    val id:Long = 0L,
    @ColumnInfo(name = "subject-name")
    val subjectName : String = "",
    @ColumnInfo(name ="class-attended")
    val classAttended : Int = 0,
    @ColumnInfo(name ="class-missed")
    val classMissed : Int = 0
)