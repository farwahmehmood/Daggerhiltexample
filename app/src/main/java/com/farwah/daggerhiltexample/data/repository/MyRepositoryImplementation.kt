package com.farwah.daggerhiltexample.data.repository

import com.farwah.daggerhiltexample.data.remote.MyApi
import com.farwah.daggerhiltexample.domain.repository.MyRepository
import com.farwah.daggerhiltexample.model.ProductItem
import retrofit2.Response

class MyRepositoryImplementation (
    private val api: MyApi
): MyRepository{
    override suspend fun doNetworkCall(): Response<List<ProductItem>> {
        return api.doNetworkCall()
    }
}