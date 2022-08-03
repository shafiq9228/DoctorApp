package com.medical.doctorapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class Home : AppCompatActivity() {


    lateinit var categorybtn: LinearLayout
    lateinit var homekitbtn: LinearLayout
    lateinit var mealbtn: LinearLayout
    lateinit var bookdoctorbtn: LinearLayout
    lateinit var logout: ImageView
    lateinit var appointment: LinearLayout

    lateinit var auth: FirebaseAuth
    private var mGoogleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        categorybtn = findViewById(R.id.categorybtn)
        homekitbtn = findViewById(R.id.homekitbtn)
        mealbtn = findViewById(R.id.mealbtn)
        bookdoctorbtn = findViewById(R.id.bookdoctorbtn)
        appointment  = findViewById(R.id.appointments)



        auth =FirebaseAuth.getInstance()
        logout = findViewById(R.id.logout)

        logout.setOnClickListener(View.OnClickListener {
            val  googleSignInClient = GoogleSignIn.getClient(
                this@Home, GoogleSignInOptions.DEFAULT_SIGN_IN
            )
            googleSignInClient.signOut().addOnCompleteListener(OnCompleteListener { task->
                if (task.isSuccessful){
                    auth.signOut()
                    val i = Intent(this@Home, GoogleSignin::class.java)
                    startActivity(i)
                    finishAffinity()
                }else{
                    Toast.makeText(applicationContext, "Failed ",Toast.LENGTH_SHORT).show()
                }
            })


        })

        appointment.setOnClickListener(View.OnClickListener {
            val i = Intent(this@Home, PatientAppointed::class.java)
            startActivity(i)
        })


        categorybtn.setOnClickListener {
            var i = Intent(this,CategoryProduct::class.java)
            startActivity(i)
        }

        homekitbtn.setOnClickListener {
            var i = Intent(this,OrderHomeKit::class.java)
            startActivity(i)
        }

        mealbtn.setOnClickListener {
            var i = Intent(this,SelectedMealPlan::class.java)
            startActivity(i)
        }

        bookdoctorbtn.setOnClickListener {
            var i = Intent(this,BookAppointment::class.java)
            startActivity(i)
        }

    }
}