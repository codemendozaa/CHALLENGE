package com.example.challengedesarrolladormobile.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val image: String = "",
    val name: String = "",
    val price: Int = 0
):Parcelable
