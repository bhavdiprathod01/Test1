package com.bmrwork.test1.MVVM.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bmrwork.test1.MVVM.data.CurrencyRate
import kotlinx.coroutines.launch

class ExchangeViewModel : ViewModel() {

    private val repository = ExchangeRepository()

    private val _rates = MutableLiveData<List<CurrencyRate>>()
    val rates: LiveData<List<CurrencyRate>> = _rates

    fun fetchRates() {
        viewModelScope.launch {
            try {
                _rates.value = repository.getCurrencyRates()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}