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

class Vitamins : AppCompatActivity() {

    lateinit var vitaminslist : RecyclerView
    lateinit var vitamins : ArrayList<ProductModel>
    lateinit var bck: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vitamins)

        bck = findViewById(R.id.bck)
        bck.setOnClickListener { finish() }
        vitaminslist = findViewById(R.id.vitaminslist)
        vitaminslist.layoutManager = LinearLayoutManager(this)
        vitamins = ArrayList()
        addlist()

    }

    fun addlist(){
        val vmodel = ProductModel (R.drawable.ic_round_medication_liquid_24 , "Anxiety & Stress Relief")
        vitamins.add(vmodel)

        val vmodel1 = ProductModel (R.drawable.ic_round_medication_liquid_24 , "Vitamin B12")
        vitamins.add(vmodel1)

        val vmodel2 = ProductModel (R.drawable.ic_round_medication_liquid_24 , "Capsules")
        vitamins.add(vmodel2)

        vitaminslist.adapter = ProductAdapter(vitamins, this@Vitamins)
    }

}