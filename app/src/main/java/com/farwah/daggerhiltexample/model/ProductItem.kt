package com.farwah.daggerhiltexample.model

import android.media.Rating
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductItem(
   val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: com.farwah.daggerhiltexample.model.Rating,
    val title: String

) : Parcelable


