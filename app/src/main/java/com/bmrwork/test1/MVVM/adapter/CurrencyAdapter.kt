package com.bmrwork.test1.MVVM.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bmrwork.test1.MVVM.data.CurrencyRate
import com.bmrwork.test1.databinding.ItemCurrencyBinding

class CurrencyAdapter :
    RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    private val list = mutableListOf<CurrencyRate>()

    fun submitList(data: List<CurrencyRate>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        val binding: ItemCurrencyBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding = ItemCurrencyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.binding.tvCode.text = item.code
        holder.binding.tvRate.text = item.rate.toString()
    }

    override fun getItemCount(): Int = list.size
}