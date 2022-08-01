package com.medical.doctorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Gallery : AppCompatActivity() {

    lateinit var bck: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        bck = findViewById(R.id.bck)
        bck.setOnClickListener { finish() }

    }
}