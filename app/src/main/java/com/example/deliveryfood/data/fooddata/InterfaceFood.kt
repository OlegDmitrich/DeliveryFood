package com.example.deliveryfood.data.fooddata

import com.example.deliveryfood.data.fooddata.Food

interface InterfaceFood { // для тестов ресайклера
    fun getFood(): List<Food>
}