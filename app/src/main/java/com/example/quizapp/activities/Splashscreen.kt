package com.example.quizapp.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_splashscreen.*

class splashscreen : AppCompatActivity() {
    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT:Long = 4000 // 1 sec
    private val auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,MainActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
      //  FirebaseApp.initializeApp();
       val auth=FirebaseAuth.getInstance()
        if(auth.currentUser != null){
            Toast.makeText(this, "Already Log In", Toast.LENGTH_SHORT).show()
            redirect("MAIN")
        }
        buttongettingstarted.setOnClickListener{
            redirect("LOGIN")
        }

    }
    private fun redirect(name: String){
        val intent: Intent =when(name){
            "LOGIN" -> Intent(this, SingIn::class.java)
            "MAIN" -> Intent(this, MainActivity::class.java)
            else -> throw Exception("No path exists")
        }
        startActivity(intent)
        finish()
    }

}