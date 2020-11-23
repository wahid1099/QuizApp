package com.example.quizapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sing_up.*


class SingUp : AppCompatActivity() {
    lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)
        firebaseAuth=FirebaseAuth.getInstance()
      singupbutton.setOnClickListener{
          singupUser()
      }
        singIntext.setOnClickListener {
            val intent= Intent(this, SingIn::class.java)
            startActivity(intent)
            finish()
        }
    }
    private  fun singupUser(){
       val email= singupemailadress.text.toString()
        val password=singupPassword.text.toString()
        val confirmpass=singupconfirmpassword.text.toString()
        if (email.isBlank() || password.isBlank() || confirmpass.isBlank()){
            Toast.makeText(this,"Email and password cant be blank",Toast.LENGTH_SHORT).show()
            return
        }
        if (password != confirmpass){
            Toast.makeText(this,"Password and confirm Password do not match",Toast.LENGTH_SHORT).show()
            return
        }
          firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
              if(it.isSuccessful){
                  Toast.makeText(this,"Sing Up SuccesFully",Toast.LENGTH_SHORT).show()
                  val intent=Intent(this, MainActivity::class.java)
                  finish()
                  startActivity(intent)
              }
              else{

              }
          }
    }
}