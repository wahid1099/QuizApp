package com.example.quizapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sing_in.*

class SingIn : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)
        //FirebaseApp.initializeApp();
        firebaseAuth=FirebaseAuth.getInstance()
        singInbutton.setOnClickListener{
            login()
        }
        singuptext.setOnClickListener {
            val intent=Intent(this, SingUp::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun login(){
        val email=singInemail.text.toString()
        val password=singInPassword.text.toString()
        if (email.isBlank() || password.isBlank()){
            Toast.makeText(this,"Email/password Cannot be empty",Toast.LENGTH_SHORT).show()
        }
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
            if (it.isSuccessful){
                Toast.makeText(this,"Success", Toast.LENGTH_SHORT).show()
                val intent=Intent(this, MainActivity::class.java)
                finish()
                startActivity(intent)
            }else{
                Toast.makeText(this,"Authentication Failed",Toast.LENGTH_SHORT).show()
            }
        }
    }
}