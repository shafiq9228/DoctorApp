package com.medical.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout

class UploadPrescription : AppCompatActivity() {

    lateinit var bck: ImageView
    lateinit var camera: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_prescription)

        bck = findViewById(R.id.bck)
        bck.setOnClickListener { finish() }

        camera = findViewById(R.id.camera)
        camera.setOnClickListener {
            var i = Intent(this,Gallery::class.java)
            startActivity(i)
        }

    }
}