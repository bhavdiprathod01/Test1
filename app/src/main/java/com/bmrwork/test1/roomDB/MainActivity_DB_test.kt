package com.bmrwork.test1.roomDB

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmrwork.test1.databinding.ActivityMainDbTestBinding
import com.bmrwork.test1.roomDB.adapter.StudentAdapter
import com.bmrwork.test1.roomDB.db.StudentDatabase
import com.bmrwork.test1.roomDB.db.StudentEntity
import com.bmrwork.test1.roomDB.repository.StudentRepository
import com.bmrwork.test1.roomDB.viewmodel.StudentViewModel
import com.bmrwork.test1.roomDB.viewmodel.StudentViewModelFactory

class MainActivity_DB_test : AppCompatActivity() {

    private lateinit var binding: ActivityMainDbTestBinding
    private lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDbTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = StudentDatabase.getDatabase(application).studentDao()
        val repository = StudentRepository(dao)
        val factory = StudentViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory)[StudentViewModel::class.java]

        val adapter = StudentAdapter {
            viewModel.deleteStudent(it)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.students.observe(this) {
            adapter.submitList(it)
        }

        binding.btnAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val course = binding.etCourse.text.toString()

            if (name.isNotEmpty()) {
                viewModel.addStudent(
                    StudentEntity(
                        name = name,
                        email = email,
                        course = course
                    )
                )
                binding.etName.text.clear()
                binding.etEmail.text.clear()
                binding.etCourse.text.clear()
            }
        }
    }
}
