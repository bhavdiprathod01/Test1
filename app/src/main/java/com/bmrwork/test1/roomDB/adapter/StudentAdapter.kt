package com.bmrwork.test1.roomDB.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bmrwork.test1.databinding.ItemStudentBinding
import com.bmrwork.test1.roomDB.db.StudentEntity

class StudentAdapter(
    private val onDelete: (StudentEntity) -> Unit
) : ListAdapter<StudentEntity, StudentAdapter.StudentViewHolder>(DiffCallback()) {

    class StudentViewHolder(val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = getItem(position)
        holder.binding.tvName.text = student.name
        holder.binding.tvEmail.text = student.email
        holder.binding.tvCourse.text = student.course

        holder.binding.btnDelete.setOnClickListener {
            onDelete(student)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<StudentEntity>() {
        override fun areItemsTheSame(old: StudentEntity, new: StudentEntity) =
            old.id == new.id

        override fun areContentsTheSame(old: StudentEntity, new: StudentEntity) =
            old == new
    }
}
