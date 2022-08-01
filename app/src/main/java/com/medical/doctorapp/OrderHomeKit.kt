package com.medical.doctorapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.Adapters.ProductAdapter
import com.medical.doctorapp.Models.ProductModel

class OrderHomeKit : AppCompatActivity() {

    lateinit var orderkitlist : RecyclerView
    lateinit var kitlist : ArrayList<ProductModel>
    lateinit var bck: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_home_kit)




        bck = findViewById(R.id.bck)
        bck.setOnClickListener { finish() }
        orderkitlist = findViewById(R.id.orderkitlist)
        orderkitlist.setOnClickListener {
            var i = Intent(this,SelectedMealPlan::class.java)
            startActivity(i)
        }
        orderkitlist.layoutManager = LinearLayoutManager(this)
        kitlist = ArrayList()
        addlist()

    }

    fun addlist(){
        var kitmodel = ProductModel(R.drawable.ic_round_medication_liquid_24 , "Blood Glucose Test")
        kitlist.add(kitmodel)

        var kitmodel1 = ProductModel(R.drawable.ic_round_medication_liquid_24 , "Covid - 19 Test")
        kitlist.add(kitmodel1)

        var kitmodel2 = ProductModel(R.drawable.ic_round_medication_liquid_24 , "Capsules")
        kitlist.add(kitmodel2)

        orderkitlist.adapter = ProductAdapter(kitlist, this@OrderHomeKit)
    }

}