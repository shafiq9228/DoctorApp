package com.medical.doctorapp

import android.content.Intent
import android.icu.util.ULocale
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import java.util.*

class Home : AppCompatActivity() {

    lateinit var prescriptionbtn: LinearLayout
    lateinit var categorybtn: LinearLayout
    lateinit var homekitbtn: LinearLayout
    lateinit var mealbtn: LinearLayout
    lateinit var bookdoctorbtn: LinearLayout
    lateinit var logout: ImageView
    private var mGoogleSignInClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        prescriptionbtn = findViewById(R.id.prescriptionbtn)
        categorybtn = findViewById(R.id.categorybtn)
        homekitbtn = findViewById(R.id.homekitbtn)
        mealbtn = findViewById(R.id.mealbtn)
        bookdoctorbtn = findViewById(R.id.bookdoctorbtn)

        logout = findViewById(R.id.logout)

        logout.setOnClickListener(View.OnClickListener {
            val  googleSignInClient = GoogleSignIn.getClient(
                this@Home, GoogleSignInOptions.DEFAULT_SIGN_IN
            )
            googleSignInClient.signOut().addOnCompleteListener(OnCompleteListener { task->
                if (task.isSuccessful){
                    val i = Intent(this@Home, SelectScrn::class.java)
                    startActivity(i)
                    finishAffinity()
                }else{
                    Toast.makeText(applicationContext, "Failed ",Toast.LENGTH_SHORT).show()
                }
            })


        })

        prescriptionbtn.setOnClickListener {
            var i = Intent(this,UploadPrescription::class.java)
            startActivity(i)
        }

        categorybtn.setOnClickListener {
            var i = Intent(this,CategoryProduct::class.java)
            startActivity(i)
        }

        homekitbtn.setOnClickListener {
            var i = Intent(this,OrderHomeKit::class.java)
            startActivity(i)
        }

        mealbtn.setOnClickListener {
            var i = Intent(this,MealPlans::class.java)
            startActivity(i)
        }

        bookdoctorbtn.setOnClickListener {
            var i = Intent(this,BookAppointment::class.java)
            startActivity(i)
        }

    }
}