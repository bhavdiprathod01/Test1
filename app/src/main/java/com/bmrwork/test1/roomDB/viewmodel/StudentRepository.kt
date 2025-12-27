package com.bmrwork.test1.roomDB.viewmodel

import com.bmrwork.test1.roomDB.db.StudentDao
import com.bmrwork.test1.roomDB.db.StudentEntity

class StudentRepository(private val dao: StudentDao) {

    suspend fun insert(student: StudentEntity) =
        dao.insertStudent(student)

    suspend fun update(student: StudentEntity) =
        dao.updateStudent(student)

    suspend fun delete(student: StudentEntity) =
        dao.deleteStudent(student)

    suspend fun getAllStudents(): List<StudentEntity> =
        dao.getAllStudents()
}