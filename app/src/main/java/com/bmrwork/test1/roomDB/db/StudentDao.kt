package com.bmrwork.test1.roomDB.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: StudentEntity)

    @Delete
    suspend fun delete(student: StudentEntity)

    @Query("SELECT * FROM students ORDER BY id DESC")
    fun getAllStudents(): Flow<List<StudentEntity>>
}
