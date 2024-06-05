package com.farwah.daggerhiltexample.domain.repository

import com.farwah.daggerhiltexample.model.ProductItem
import retrofit2.Response

interface MyRepository {
    suspend fun doNetworkCall(): Response<List<ProductItem>>
}