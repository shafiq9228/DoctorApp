package com.medical.doctorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.Adapters.MealAdapter
import com.medical.doctorapp.Models.MealModel

class SelectedMealPlan : AppCompatActivity() {

    lateinit var orderkitlist : RecyclerView
    lateinit var meallist : ArrayList<MealModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_meal_plan)

        orderkitlist = findViewById(R.id.selectedmealplans)
        orderkitlist.layoutManager = LinearLayoutManager(this)
        meallist = ArrayList()
        addlist()

    }

    fun addlist(){

        var mealModel = MealModel(R.drawable.ic_baseline_lunch_dining_24 , "Breakfast" , "Strawberry, Peach &\nAlmond Milk Smoothie")
        meallist.add(mealModel)

        var mealModel1 = MealModel(R.drawable.ic_baseline_lunch_dining_24 , "Lunch" , "Lentil Stew with Spinach\nand Fresh Herbs")
        meallist.add(mealModel1)

        var mealModel2 = MealModel(R.drawable.ic_baseline_lunch_dining_24 , "Dinner" , "Baked Chiken Parmesan \nwith Passley")
        meallist.add(mealModel2)

        orderkitlist.adapter = MealAdapter(meallist, this)

    }

}