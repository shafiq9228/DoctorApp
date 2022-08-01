package com.medical.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Signup : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var mobile: EditText
    lateinit var address: EditText
    lateinit var age: EditText
    lateinit var auth: FirebaseAuth
    lateinit var malecb: CheckBox
    lateinit var femalecb: CheckBox
    lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        email = findViewById(R.id.memail)
        mobile = findViewById(R.id.mmobile)
        address = findViewById(R.id.maddress)
        auth = FirebaseAuth.getInstance();
        age = findViewById(R.id.mage)
        malecb = findViewById(R.id.malecb)
        femalecb = findViewById(R.id.femalecb)

        email.setText(""+auth.currentUser?.email)
        submit = findViewById(R.id.sumbit)

        malecb.isChecked = true

        malecb.setOnClickListener(View.OnClickListener {
            femalecb.isChecked = false
            malecb.isChecked = true
        })


        femalecb.setOnClickListener(View.OnClickListener {
            malecb.isChecked = false
            femalecb.isChecked = true
        })

        submit.setOnClickListener(View.OnClickListener {
            if (mobile.text.toString().isEmpty() || age.text.toString().isEmpty() || address.text.toString().isEmpty() ){
                Toast.makeText(applicationContext, "Please Fill All Details", Toast.LENGTH_SHORT).show()

            }else{
                val i = Intent(this@Signup, Home::class.java)
                startActivity(i)
                finishAffinity()
            }
        })



    }
}