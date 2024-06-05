package com.farwah.daggerhiltexample.data.remote

import com.farwah.daggerhiltexample.model.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("/products")
    suspend fun doNetworkCall(): Response<List<ProductItem>>
}