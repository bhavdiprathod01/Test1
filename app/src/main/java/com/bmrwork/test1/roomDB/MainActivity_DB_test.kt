package com.bmrwork.test1.roomDB

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmrwork.test1.R
import com.bmrwork.test1.databinding.ActivityMainBinding
import com.bmrwork.test1.databinding.ActivityMainDbTestBinding
import com.bmrwork.test1.roomDB.adapter.StudentAdapter
import com.bmrwork.test1.roomDB.db.StudentEntity
import com.bmrwork.test1.roomDB.viewmodel.StudentViewModel

class MainActivity_DB_test : AppCompatActivity() {
    private lateinit var binding: ActivityMainDbTestBinding
    private lateinit var viewModel: StudentViewModel
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_db_test)
        binding = ActivityMainDbTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[StudentViewModel::class.java]

        adapter = StudentAdapter {
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

        viewModel.loadStudents()
    }
}