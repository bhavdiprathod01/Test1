package com.bmrwork.test1.roomDB.repository

import com.bmrwork.test1.roomDB.db.StudentDao
import com.bmrwork.test1.roomDB.db.StudentEntity

class StudentRepository(private val dao: StudentDao) {

    val students = dao.getAllStudents()

    suspend fun insert(student: StudentEntity) {
        dao.insert(student)
    }

    suspend fun delete(student: StudentEntity) {
        dao.delete(student)
    }
}
