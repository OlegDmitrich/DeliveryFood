package com.example.deliveryfood.data.fooddata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(

    val nameFood: String = "Pizza",
    val descriptionFood: String = "Very good pizza mmmmmmm"

): Parcelable
