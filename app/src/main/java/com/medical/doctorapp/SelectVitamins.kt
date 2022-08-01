package com.medical.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class SelectVitamins : AppCompatActivity() {

    lateinit var orderbtn: Button

    lateinit var bck: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_vitamins)

        bck = findViewById(R.id.bck)
        bck.setOnClickListener { finish() }
        orderbtn = findViewById(R.id.orderbtn)
        orderbtn.setOnClickListener {
            val i = Intent(this,PaymentDetails::class.java)
            startActivity(i)
        }

    }
}