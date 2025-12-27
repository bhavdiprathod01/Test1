package com.bmrwork.test1.MVVM.viewmodel

import com.bmrwork.test1.MVVM.data.CurrencyRate
import com.bmrwork.test1.MVVM.retrofit.RetrofitInstance

class ExchangeRepository {

    suspend fun getCurrencyRates(): List<CurrencyRate> {
        val response = RetrofitInstance.api.getRates()
        return response.conversion_rates.map {
            CurrencyRate(it.key, it.value)
        }
    }
}