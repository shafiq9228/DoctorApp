package com.pharma.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    lateinit var signuptxt: TextView
    lateinit var loginbtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signuptxt = findViewById(R.id.signuptxt)
        loginbtn = findViewById(R.id.loginbtn)
        signuptxt.setOnClickListener(View.OnClickListener {
           finish()
        })

        loginbtn.setOnClickListener(View.OnClickListener {
            val i = Intent(this, DashBoardActivity::class.java)
            startActivity(i)
            finish()
        })


    }
}