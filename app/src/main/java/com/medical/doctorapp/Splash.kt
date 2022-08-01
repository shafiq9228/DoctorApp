package com.medical.doctorapp

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth


class Splash : AppCompatActivity() {

    lateinit var myanim: LottieAnimationView
    lateinit var h: Handler

    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//
        myanim = findViewById(R.id.myanim)
        myanim.playAnimation()


        auth = FirebaseAuth.getInstance();



        myanim.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {



            }

            override fun onAnimationEnd(animation: Animator) {
                if (auth.currentUser != null){
                    val i = Intent(this@Splash, Home::class.java)
                    startActivity(i)
                    finish()
                }else{
                    val i = Intent(this@Splash, GetStart::class.java)
                    startActivity(i)
                    finish()
                }

            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        })


    }


}