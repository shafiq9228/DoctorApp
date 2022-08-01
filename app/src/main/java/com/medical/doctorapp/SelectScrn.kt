package com.medical.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SelectScrn : AppCompatActivity() {

    lateinit var dochome: Button
    lateinit var patienthome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_scrn)

        dochome = findViewById(R.id.dochome)
        patienthome = findViewById(R.id.patienthome)

        dochome.setOnClickListener {
            val i = Intent(this,DoctorHome::class.java)
            startActivity(i)
        }

        patienthome.setOnClickListener {
            val i = Intent (this,Home::class.java)
            startActivity(i)
        }

    }
}