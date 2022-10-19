package com.example.deliveryfood.data.burgerdata

import com.example.deliveryfood.data.burgerdata.Addresse

data class BurgerItem(
    val addresses: List<Addresse>,
    val description: String,
    val id: Int,
    val ingredients: List<String>,
    val name: String,
    val restaurant: String,
    val web: String
)