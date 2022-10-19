package com.example.deliveryfood.data

import com.example.deliveryfood.data.burgerdata.Burger
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface BurgerApi {

    @Headers("X-RapidAPI-Key: 04f3d9d5b9msh51057795783f3e9p1ee4cajsnb47f6c3aa080","X-RapidAPI-Host: burgers1.p.rapidapi.com")
    @GET("https://burgers1.p.rapidapi.com/burgers")

    fun getBurgerData():Call<Burger>
}