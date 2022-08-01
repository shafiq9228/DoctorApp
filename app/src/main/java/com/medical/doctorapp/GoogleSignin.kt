package com.medical.doctorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class GoogleSignin : AppCompatActivity() {

    lateinit var mailbtn: LinearLayout
    var googlebtn: LinearLayout? = null
    lateinit var signInRequest: BeginSignInRequest
    lateinit var auth: FirebaseAuth

    private var mGoogleSignInClient: GoogleSignInClient? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_signin)

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("743878705625-s1m760hpc1eqmc1d8np6qv5cntplinsh.apps.googleusercontent.com")
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)



        mailbtn = findViewById(R.id.mailbtn)
        mailbtn.setOnClickListener {

            signIn()
        }

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {

            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!

                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Toast.makeText(applicationContext, "failed "+e.message, Toast.LENGTH_SHORT ).show()


            }
        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val b1 = task.getResult().additionalUserInfo?.isNewUser

                    val i = Intent(this@GoogleSignin, Signup::class.java)
                    startActivity(i)
                    finishAffinity()
//                    if (b1!!){
//
//                    }else{
//                        Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
//                        val user = auth.currentUser
//                        val i = Intent(this@GoogleSignin, Home::class.java)
//                        startActivity(i)
//                        finishAffinity()
//                    }


                } else {
                    Toast.makeText(applicationContext, "Faied", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun signIn() {


        val signInIntent: Intent = mGoogleSignInClient!!.getSignInIntent()
        startActivityForResult(signInIntent, RC_SIGN_IN)

    }
    // [END signin]


    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }
}