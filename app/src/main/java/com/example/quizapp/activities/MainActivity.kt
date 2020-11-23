package com.example.quizapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizapp.R
import com.example.quizapp.activities.adapters.QuizAdapter
import com.example.quizapp.activities.models.Quiz
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
     lateinit var adapter: QuizAdapter
    private var quizlist= mutableListOf<Quiz>()
    lateinit var firestore: FirebaseFirestore
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populetDummyData()
        setUpViews()
    }
    fun setUpViews(){
        setUpFireStores()
        setUpDrawerLayout()
        setUpRecyclerView()
    }

    private fun setUpFireStores() {
         firestore= FirebaseFirestore.getInstance()
        val collectionReference=firestore.collection("quizzes")
        collectionReference.addSnapshotListener {
            value, error ->
            if(value==null || error !=null){
                Toast.makeText(this,"Error fetching data",Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }
            Log.d("Data",value.toObjects(Quiz::class.java).toString())
        }

    }

    fun populetDummyData(){
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))
        quizlist.add(Quiz("12.12.12","12.10.12"))


    }
    fun setUpDrawerLayout(){
         setSupportActionBar(topAppBar)
        actionBarDrawerToggle= ActionBarDrawerToggle(this,main_drawer, R.string.app_name, R.string.app_name)
        actionBarDrawerToggle.syncState()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }


        return super.onOptionsItemSelected(item)
    }
   private fun setUpRecyclerView(){
        adapter=QuizAdapter(this,quizlist)
       quiz_recyclerView.layoutManager=GridLayoutManager(this,2)
          quiz_recyclerView.adapter=adapter
    }
}