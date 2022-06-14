package com.pharma.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {
   lateinit var logintxt: TextView
   lateinit var signupbtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


       logintxt = findViewById(R.id.logintxt)
        signupbtn = findViewById(R.id.signupbtn)
        logintxt.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })

        signupbtn.setOnClickListener(View.OnClickListener {
            val i = Intent(this, DashBoardActivity::class.java)
            startActivity(i)
            finish()
        })
    }
}