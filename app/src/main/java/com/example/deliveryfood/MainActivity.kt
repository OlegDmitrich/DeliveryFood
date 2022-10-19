package com.example.deliveryfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.deliveryfood.databinding.ActivityMainBinding
import com.example.deliveryfood.ui.BasketFragment
import com.example.deliveryfood.ui.FoodMenuFragment
import com.example.deliveryfood.ui.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.bottom_navigation_view_container,FoodMenuFragment())
                .commit()
        }

        with(binding){
            bottomNavigationView.setOnItemSelectedListener { item->
              when(item.itemId){
                  R.id.food_menu -> {
                      supportFragmentManager.beginTransaction()
                          .replace(R.id.bottom_navigation_view_container,FoodMenuFragment())
                          .addToBackStack(null)
                          .commit()
                      true
                  }
                  R.id.profile ->{
                      supportFragmentManager.beginTransaction()
                          .replace(R.id.bottom_navigation_view_container,ProfileFragment())
                          .addToBackStack(null)
                          .commit()
                      true
                  }
                  R.id.basket ->{
                      supportFragmentManager.beginTransaction()
                          .replace(R.id.bottom_navigation_view_container,BasketFragment())
                          .addToBackStack(null)
                          .commit()
                      true
                  }else ->false
//                  else -> {
//                          supportFragmentManager.beginTransaction()
//                              .replace(R.id.bottom_navigation_view_container,FoodMenuFragment())
//                              .commit()
//                          true
//                  }

                }
            }
        }
    }



}