package com.medical.doctorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class FoodDetails : AppCompatActivity() {
    lateinit var dtitle: TextView
    var title: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        dtitle = findViewById(R.id.dtitle)
        title = intent.getStringExtra("title").toString()
        dtitle.setText(""+title)

    }
}