package com.medical.doctorapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.Adapters.ProductAdapter
import com.medical.doctorapp.Models.ProductModel

class MealPlans : AppCompatActivity() {


    lateinit var meallist: RecyclerView
    lateinit var arrayList: ArrayList<ProductModel>
    lateinit var bck: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_plans)

        bck = findViewById(R.id.bck)
        bck.setOnClickListener { finish() }
        meallist = findViewById(R.id.meallist)
        meallist.layoutManager = LinearLayoutManager(this)
        arrayList = ArrayList();
        addlist()

    }

    fun addlist(){
        val pd  = ProductModel(R.drawable.ic_round_medication_liquid_24, "Diabetic Meal Plan")
        arrayList.add(pd)

        val pd2  = ProductModel(R.drawable.ic_round_medication_liquid_24, "High Cholesterol Meal Plan")
        arrayList.add(pd2)

        val pd3  = ProductModel(R.drawable.ic_round_medication_liquid_24, "Diabetic Meal Plan")
        arrayList.add(pd3)

        meallist.adapter = ProductAdapter(arrayList, this@MealPlans)
    }
}