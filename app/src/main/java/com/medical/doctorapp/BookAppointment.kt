package com.medical.doctorapp

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import java.util.*

class BookAppointment : AppCompatActivity() {

    lateinit var bck: ImageView
    lateinit var mydate: TextView
    lateinit var bookbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)

        bck = findViewById(R.id.bck)
       bck.setOnClickListener(View.OnClickListener {
           finish()
       })
        bookbtn = findViewById(R.id.bookbtn)
        bookbtn.setOnClickListener {
            var i = Intent(this,AppointmentConfirmed::class.java)
            startActivity(i)
        }
        mydate = findViewById(R.id.mydate)
        var c = Calendar.getInstance();
//        var year = c.get(Calendar.YEAR)
//        var month = c.get(Calendar.MONTH)
//        var day = c.get(Calendar.DAY_OF_MONTH)

        mydate.setOnClickListener(View.OnClickListener {



            DatePickerDialog(this@BookAppointment,
                DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
                    mydate.setText(""+year+" "+month+" "+dayOfMonth)
                },
                // set DatePickerDialog to point to today's date when it loads up


                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)).show()




        })
    }
}