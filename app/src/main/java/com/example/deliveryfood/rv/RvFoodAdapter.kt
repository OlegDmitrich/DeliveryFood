package com.example.deliveryfood.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.R
import com.example.deliveryfood.data.burgerdata.Burger
import com.example.deliveryfood.data.fooddata.Food

class RvFoodAdapter: RecyclerView.Adapter<FoodViewHolder>() {

    private var data: List<Food> = emptyList()
    private var dataBurger: Burger = Burger()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.rv_item_food,parent,false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
       holder.bind(dataBurger[position],position)

    }

    override fun getItemCount(): Int {
       return dataBurger.size

    }



    fun setDataBurger(listBurger: Burger) {
        dataBurger = listBurger
        notifyDataSetChanged()
    }
}


