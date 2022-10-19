package com.example.deliveryfood.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryfood.data.burgerdata.Burger
import com.example.deliveryfood.data.fooddata.Food
import com.example.deliveryfood.databinding.FoodMenuTwoBinding
import com.example.deliveryfood.model.AppState
import com.example.deliveryfood.model.FoodViewModel
import com.example.deliveryfood.rv.RvFoodAdapter

class TwoFoodMenuFragment: Fragment() {

    private lateinit var binding: FoodMenuTwoBinding
    private lateinit var viewModel: FoodViewModel
    private val adapter = RvFoodAdapter()

    companion object{
        fun newInstance() = TwoFoodMenuFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FoodMenuTwoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[FoodViewModel::class.java]
       // viewModel.getFood().observe(viewLifecycleOwner){state -> render(state)}
        viewModel.captureBurger().observe(viewLifecycleOwner){state -> render(state)}
        initAdapter()
    }

    private fun render(state: AppState?) {

        when(state){
            is AppState.SuccessBurger ->{
                val listFood: Burger = state.servBurger
                adapter.setDataBurger(listFood )
            }
            else->{}
        }

    }

    private fun initAdapter() {
        with(binding){
            rvBurgerMenu.layoutManager = LinearLayoutManager(activity)
            //  adapter.setHasStableIds(true)
            rvBurgerMenu.adapter = adapter
        }

    }
}