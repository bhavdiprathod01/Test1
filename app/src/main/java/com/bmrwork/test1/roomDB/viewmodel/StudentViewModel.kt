package com.bmrwork.test1.roomDB.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bmrwork.test1.roomDB.db.StudentDatabase
import com.bmrwork.test1.roomDB.db.StudentEntity
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) :
    AndroidViewModel(application) {

    private val dao =
        StudentDatabase.Companion.getDatabase(application).studentDao()

    private val repository = StudentRepository(dao)

    private val _students = MutableLiveData<List<StudentEntity>>()
    val students: LiveData<List<StudentEntity>> = _students

    fun loadStudents() {
        viewModelScope.launch {
            _students.value = repository.getAllStudents()
        }
    }

    fun addStudent(student: StudentEntity) {
        viewModelScope.launch {
            repository.insert(student)
            loadStudents()
        }
    }

    fun deleteStudent(student: StudentEntity) {
        viewModelScope.launch {
            repository.delete(student)
            loadStudents()
        }
    }
}