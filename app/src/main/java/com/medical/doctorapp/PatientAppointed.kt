package com.medical.doctorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medical.doctorapp.Adapters.AppointedAdapter
import com.medical.doctorapp.Adapters.DoctorAdapter
import com.medical.doctorapp.Models.AppointedModel
import com.medical.doctorapp.Models.DoctorModel

class PatientAppointed : AppCompatActivity() {

    lateinit var appointedlist: RecyclerView
    lateinit var patientlist: ArrayList<DoctorModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_appointed)

        appointedlist = findViewById(R.id.appointedlist)
        appointedlist.layoutManager = LinearLayoutManager(this)
        patientlist = ArrayList()
        addlist()

    }

    fun addlist(){

        var doctormodel = DoctorModel("Ahmed Khan" , "Dentist", "12/07/2022", "confirmed")
        patientlist.add(doctormodel)

        var doctormodel2 = DoctorModel("Ahmed Khan" , "Dentist", "12/07/2022", "confirmed")
        patientlist.add(doctormodel2)

        appointedlist.adapter = DoctorAdapter(patientlist)

    }

}