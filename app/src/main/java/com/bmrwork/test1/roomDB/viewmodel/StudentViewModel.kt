package com.bmrwork.test1.roomDB.viewmodel

import androidx.lifecycle.*
import com.bmrwork.test1.roomDB.db.StudentEntity
import com.bmrwork.test1.roomDB.repository.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(
    private val repository: StudentRepository
) : ViewModel() {

    val students = repository.students.asLiveData()

    fun addStudent(student: StudentEntity) {
        viewModelScope.launch {
            repository.insert(student)
        }
    }

    fun deleteStudent(student: StudentEntity) {
        viewModelScope.launch {
            repository.delete(student)
        }
    }
}
