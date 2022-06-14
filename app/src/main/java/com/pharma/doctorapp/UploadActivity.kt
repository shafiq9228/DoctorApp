package com.pharma.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class UploadActivity : AppCompatActivity() {
    lateinit var camerabtn: LinearLayout
    lateinit var gallerybtn: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)


        camerabtn = findViewById(R.id.camerabtn)
        gallerybtn = findViewById(R.id.gallerybtn)

        camerabtn.setOnClickListener(View.OnClickListener {
            val i = Intent(this, ShippingActivity::class.java)
            startActivity(i)
        })

        gallerybtn.setOnClickListener(View.OnClickListener {
            val i = Intent(this, ShippingActivity::class.java)
            startActivity(i)
        })

    }
}