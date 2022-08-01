package com.medical.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class GetStart : AppCompatActivity() {

    lateinit var startbtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_start)

       startbtn = findViewById(R.id.startbtn)
       startbtn.setOnClickListener {
       val i =   Intent(this,GoogleSignin::class.java)
           startActivity(i)


       }

    }
}