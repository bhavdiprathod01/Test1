package com.bmrwork.test1.roomDB.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bmrwork.test1.roomDB.db.StudentEntity

@Dao
interface StudentDao {

    @Insert
    suspend fun insertStudent(student: StudentEntity)

    @Update
    suspend fun updateStudent(student: StudentEntity)

    @Delete
    suspend fun deleteStudent(student: StudentEntity)

    @Query("SELECT * FROM student_table ORDER BY id DESC")
    suspend fun getAllStudents(): List<StudentEntity>
}