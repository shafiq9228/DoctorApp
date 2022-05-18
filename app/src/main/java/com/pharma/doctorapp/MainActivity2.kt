package com.pharma.doctorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class MainActivity2 : AppCompatActivity() {
    lateinit var emailet: EditText
    lateinit var passwordet: EditText
    lateinit var loginbtn: Button
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        firebaseAuth = FirebaseAuth.getInstance();
        passwordet = findViewById(R.id.passwordet)
        loginbtn = findViewById(R.id.loginbtn)
        emailet = findViewById(R.id.emailet)


        loginbtn.setOnClickListener(View.OnClickListener {
            if (emailet.text.toString().isEmpty() || passwordet.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Please Fill All Fields", Toast.LENGTH_SHORT).show()
            }
            else{
                loguser(emailet.text.toString(), passwordet.text.toString())
            }
        })

    }

    private fun loguser(email: String, password: String) {

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(OnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(applicationContext, "Logged In", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(applicationContext, "Failed "+it.exception, Toast.LENGTH_SHORT).show()
                }
            })

    }
}