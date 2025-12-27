package com.bmrwork.test1.MVVM

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bmrwork.test1.MVVM.adapter.CurrencyAdapter
import com.bmrwork.test1.MVVM.viewmodel.ExchangeViewModel
import com.bmrwork.test1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ExchangeViewModel
    private val adapter = CurrencyAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ExchangeViewModel::class.java]

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.rates.observe(this) {
            adapter.submitList(it)
        }

        viewModel.fetchRates()
    }
}