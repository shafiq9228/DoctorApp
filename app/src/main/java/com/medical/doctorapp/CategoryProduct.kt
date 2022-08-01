package com.medical.doctorapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.Adapters.ProductAdapter
import com.medical.doctorapp.Models.ProductModel

class CategoryProduct : AppCompatActivity() {

    lateinit var productlist : RecyclerView
    lateinit var myproductlist : ArrayList<ProductModel>
    lateinit var bck: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_product)

        bck = findViewById(R.id.bck)
        bck.setOnClickListener { finish() }
        productlist = findViewById(R.id.productlist)
        productlist.layoutManager = LinearLayoutManager(this)
        myproductlist = ArrayList()
        addlist()

    }

    fun addlist(){
        val pdmodel = ProductModel(R.drawable.ic_round_medication_liquid_24 , "Syrups")
        myproductlist.add(pdmodel)

        val pdmodel1 = ProductModel(R.drawable.ic_round_medication_liquid_24 , "Tablets")
        myproductlist.add(pdmodel1)

        val pdmodel2 = ProductModel(R.drawable.ic_round_medication_liquid_24 , "Capsules")
        myproductlist.add(pdmodel2)

        val pdmodel3 = ProductModel(R.drawable.ic_round_medication_liquid_24 , "Vitamins")
        myproductlist.add(pdmodel3)

        productlist.adapter = ProductAdapter(myproductlist, this@CategoryProduct)
    }

}