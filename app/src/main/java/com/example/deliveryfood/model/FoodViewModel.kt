package com.example.deliveryfood.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliveryfood.data.RetrofitImpl
import com.example.deliveryfood.data.burgerdata.Burger
import com.example.deliveryfood.data.fooddata.FoodServImpl
import com.example.deliveryfood.data.fooddata.InterfaceFood
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodViewModel(
    private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData(),
    private val servFood: InterfaceFood = FoodServImpl(),
    private val retrofitImpl: RetrofitImpl = RetrofitImpl()

    ):ViewModel() {


    fun getFood(): MutableLiveData<AppState> {
        liveDataToObserver.value = AppState.Success(servFood.getFood())
        return liveDataToObserver
    }

    fun captureBurger():MutableLiveData<AppState>{
        sendServerRequest()
        return liveDataToObserver
    }

    fun sendServerRequest(){
        retrofitImpl.getRetrofitImpl().getBurgerData().enqueue(object :
        Callback<Burger>{
            override fun onResponse(call: Call<Burger>, response: Response<Burger>) {
                if (response.isSuccessful && response.body() != null){
                    liveDataToObserver.value = AppState.SuccessBurger(response.body()!!)
                }else{
                    val  message = response.message()
                    if (message.isNullOrEmpty()){
                        liveDataToObserver.value = AppState.Error(Throwable("undefield error"))
                    }else{
                        liveDataToObserver.value = AppState.Error(Throwable(message))
                    }
                }
            }

            override fun onFailure(call: Call<Burger>, t: Throwable) {
                liveDataToObserver.value = AppState.Error(t)
            }

        })
    }



}