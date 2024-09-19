package com.example.proxymate.database

import kotlinx.coroutines.flow.Flow

class SubjectRepository(private val subjectDao : SubjectDAO) {
    suspend fun addASubject(subject : Subject){
        subjectDao.addSubject(subject)
    }
    fun getSubject(): Flow<List<Subject>> = subjectDao.getAllSubjects()

    fun getASubjectById(id:Long) : Flow<Subject>{
        return subjectDao.getASubjectById(id)
    }

    suspend fun updateASubject(subject: Subject){
        subjectDao.updateASubject(subject)
    }

    suspend fun deleteASubject(subject: Subject){
        subjectDao.deleteASubject(subject)
    }
}