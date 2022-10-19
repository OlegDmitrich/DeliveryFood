package com.example.deliveryfood.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.deliveryfood.R
import com.example.deliveryfood.databinding.FoodMenyBottomFragmentBinding
import com.example.deliveryfood.model.FoodViewModel
import com.example.deliveryfood.rv.RvFoodAdapter
import com.example.deliveryfood.rv.VPAdapter
import com.google.android.material.tabs.TabLayoutMediator

class FoodMenuFragment: Fragment() {

    private lateinit var binding: FoodMenyBottomFragmentBinding
    private lateinit var viewModel: FoodViewModel
    private val adapter = RvFoodAdapter()
    private val fraglist = listOf(
        OneFoodMenuFragment.newInstance(),
        TwoFoodMenuFragment.newInstance(),
        ThreeFoodMenuFragment.newInstance(),
        ForeFoodMenuFragment.newInstance(),
        FiveFoodMenuFragment.newInstance(),
    )
    private val texttitle = listOf("Pizza","Burger","coffee","sushi","Shaurma")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FoodMenyBottomFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterVP = VPAdapter(this,fraglist)
        binding.foodContainer.adapter = adapterVP
        TabLayoutMediator(binding.tab,binding.foodContainer){
            tab, pos -> tab.text = texttitle[pos]
        }.attach()



//        binding.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//
//                    requireActivity().supportFragmentManager.beginTransaction()
//                        .replace(R.id.food_container, fraglist[tab?.position!!])
//                        .addToBackStack(null)
//                        .commit()
//
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//        })
//        viewModel = ViewModelProvider(this)[FoodViewModel::class.java]
//        viewModel.getFood().observe(viewLifecycleOwner){state -> render(state)}
//        initAdapter()
    }

//    private fun render(state: AppState?) {
//
//        when(state){
//            is AppState.Success ->{
//                val listFood: List<Food> = state.servFood
//                adapter.setData(listFood )
//            }
//            else->{}
//        }
//
//    }
//
//    private fun initAdapter() {
//        with(binding){
//            rvFoodMenu.layoutManager = LinearLayoutManager(activity)
//          //  adapter.setHasStableIds(true)
//            rvFoodMenu.adapter = adapter
//        }
//
//    }
}