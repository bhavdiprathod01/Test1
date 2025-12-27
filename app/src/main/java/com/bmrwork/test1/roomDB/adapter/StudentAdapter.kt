package com.bmrwork.test1.roomDB.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bmrwork.test1.databinding.ItemStudentBinding
import com.bmrwork.test1.roomDB.db.StudentEntity

class StudentAdapter(
    private val onDelete: (StudentEntity) -> Unit
) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    private val list = mutableListOf<StudentEntity>()

    fun submitList(data: List<StudentEntity>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        val binding: ItemStudentBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemStudentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = list[position]

        holder.binding.tvName.text = student.name
        holder.binding.tvEmail.text = student.email
        holder.binding.tvCourse.text = student.course

        holder.binding.btnDelete.setOnClickListener {
            onDelete(student)
        }
    }

    override fun getItemCount() = list.size
}