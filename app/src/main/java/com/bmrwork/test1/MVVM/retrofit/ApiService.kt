package com.bmrwork.test1.MVVM.retrofit

import com.bmrwork.test1.MVVM.data.ExchangeRateResponse
import retrofit2.http.GET

interface ApiService {

    @GET("latest/USD")
    suspend fun getRates(): ExchangeRateResponse
}