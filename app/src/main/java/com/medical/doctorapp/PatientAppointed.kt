package com.medical.doctorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.Adapters.AppointedAdapter
import com.medical.doctorapp.Models.AppointedModel

class PatientAppointed : AppCompatActivity() {

    lateinit var appointedlist: RecyclerView
    lateinit var patientlist: ArrayList<AppointedModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_appointed)

        appointedlist = findViewById(R.id.appointedlist)
        appointedlist.layoutManager = LinearLayoutManager(this)
        patientlist = ArrayList()
        addlist()

    }

    fun addlist(){

        var patientmodel = AppointedModel("Ahmed Khan" , "July 25, 9pm")
        patientlist.add(patientmodel)

        var patientmodel1 = AppointedModel("Ahmed Khan" , "July 25, 9pm")
        patientlist.add(patientmodel1)

        var patientmodel2 = AppointedModel("Ahmed Khan" , "July 25, 9pm")
        patientlist.add(patientmodel2)

        var patientmodel3 = AppointedModel("Ahmed Khan" , "July 25, 9pm")
        patientlist.add(patientmodel3)

        appointedlist.adapter = AppointedAdapter(patientlist)

    }

}