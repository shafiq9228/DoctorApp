package com.medical.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class DoctorHome : AppCompatActivity() {

    lateinit var patlistbtn: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_home)

        patlistbtn = findViewById(R.id.patlistbtn)
        patlistbtn.setOnClickListener {
            val i = Intent(this,PatientAppointed::class.java)
            startActivity(i)
        }

    }
}