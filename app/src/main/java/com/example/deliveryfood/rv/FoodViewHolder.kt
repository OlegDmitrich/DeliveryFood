package com.example.deliveryfood.rv

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.data.burgerdata.BurgerItem
import com.example.deliveryfood.data.fooddata.Food
import com.example.deliveryfood.databinding.RvItemFoodBinding

class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val binding = RvItemFoodBinding.bind(itemView)

    fun bind(foodServImpl: BurgerItem, position: Int) = with(binding){
          //  textFood.text = foodServImpl.nameFood
            nameFood.text = foodServImpl.name
            nameRestaurant.text = foodServImpl.restaurant
            nameWebSite.text = foodServImpl.web
            description.text = foodServImpl.description
    }

    fun bindFood(foodServImpl: Food, position: Int) = with(binding){
          nameFood.text = foodServImpl.nameFood

    }

}
