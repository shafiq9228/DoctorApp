package com.medical.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PaymentDetails : AppCompatActivity() {

    lateinit var orderconf: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_details)

        orderconf = findViewById(R.id.orderconf)
        orderconf.setOnClickListener {
            var i = Intent(this,ProductSuccess::class.java)
            i.putExtra("type", 0)
            startActivity(i)
        }

    }
}