package com.farwah.daggerhiltexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farwah.daggerhiltexample.domain.repository.MyRepository
import com.farwah.daggerhiltexample.model.ProductItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
): ViewModel() {
    val productList: MutableLiveData<Response<List<ProductItem>>> = MutableLiveData()
    fun getProductViewModel() {
        viewModelScope.launch {
            productList.value = repository.doNetworkCall()
        }
    }

}


