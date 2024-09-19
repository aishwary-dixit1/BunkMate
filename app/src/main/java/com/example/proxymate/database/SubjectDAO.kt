package com.example.proxymate.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
abstract class SubjectDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun addSubject(subjectEntity : Subject)

    @Query("SELECT * FROM `subject-table`")
    abstract fun getAllSubjects() : Flow<List<Subject>>

    @Update
    abstract suspend fun updateASubject(subjectEntity: Subject)

    @Delete
    abstract suspend fun deleteASubject(subjectEntity: Subject)

    @Query("SELECT * FROM `subject-table`")
    abstract fun getASubjectById(id:Long): Flow<Subject>

}