package com.medical.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class ProductSuccess : AppCompatActivity() {
    lateinit var homebtn: Button
    lateinit var showimg: ImageView
    var type: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_success)


        type = intent.getIntExtra("type", 0)

        showimg =  findViewById(R.id.showimg)
        homebtn = findViewById(R.id.homebtn)
        homebtn.setOnClickListener(View.OnClickListener {
            val i = Intent(this@ProductSuccess, Home::class.java)
            startActivity(i)
            finishAffinity()
        })
        if (type== 0){
            showimg.setImageResource(R.drawable.pack)
        }else{
            showimg.setImageResource(R.drawable.dimg)

        }



    }

    override fun onBackPressed() {
        super.onBackPressed()
        val i = Intent(this@ProductSuccess, Home::class.java)
        startActivity(i)
        finishAffinity()
    }
}