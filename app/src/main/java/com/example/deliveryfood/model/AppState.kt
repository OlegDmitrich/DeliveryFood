package com.example.deliveryfood.model

import com.example.deliveryfood.data.burgerdata.Burger
import com.example.deliveryfood.data.fooddata.Food

sealed class AppState{

    data class SuccessBurger(val servBurger: Burger):AppState()
    data class Success(val servFood: List<Food>): AppState()
    data class Error(val error: Throwable): AppState()
    data class Loading(val  progress: Int?): AppState()

}
