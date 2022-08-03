package com.medical.doctorapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class BookAppointment : AppCompatActivity() {

    lateinit var bck: ImageView
    lateinit var mydate: TextView
    lateinit var bookbtn: Button
    var hour = 0;
    var Names = arrayOf("Deepak", "Akhil", "Fazil", "uday")

    var minute = 0
    lateinit var spinner: Spinner
    lateinit var dtime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)

        bck = findViewById(R.id.bck)
       bck.setOnClickListener(View.OnClickListener {
           finish()
       })

        spinner = findViewById(R.id.spinner)

     val  arrayAdapter = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, Names)
        spinner.setAdapter(arrayAdapter)


        dtime = findViewById(R.id.dtime)
        bookbtn = findViewById(R.id.bookbtn)
        bookbtn.setOnClickListener {
            var i = Intent(this,ProductSuccess::class.java)
            i.putExtra("type", 1)
            startActivity(i)
        }
        mydate = findViewById(R.id.mydate)
        var c = Calendar.getInstance();



        dtime.setOnClickListener(View.OnClickListener {
            val timePickerDialog = TimePickerDialog(this@BookAppointment,
                { view, hourOfDay, minut ->
                 val   mytime = " $hourOfDay:$minut:00"
                    dtime.setText(mytime)

                    //  enddate.setText(newlastdate);
                }, hour, minute, false
            )
            timePickerDialog.show()
        })

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