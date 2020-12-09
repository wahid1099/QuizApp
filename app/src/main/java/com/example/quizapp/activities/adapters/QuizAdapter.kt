package com.example.quizapp.activities.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.activities.QustionActivity
import com.example.quizapp.activities.models.Quiz
import com.example.quizapp.activities.utils.ColorPicker
import com.example.quizapp.activities.utils.iconpicker
import kotlinx.android.synthetic.main.quiz_item.view.*

class QuizAdapter (val context:Context,val quizzes:List<Quiz>): RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {
    inner class QuizViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var textViewtitle :TextView=itemView.findViewById(R.id.quizTitle)
        var iconview :ImageView=itemView.findViewById(R.id.quizIcon)
        var cardcontainer:CardView=itemView.findViewById(R.id.cardContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
       val view=LayoutInflater.from(context).inflate(R.layout.quiz_item,parent,false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.textViewtitle.text=quizzes[position].title
        holder.cardcontainer.setCardBackgroundColor(Color.parseColor((ColorPicker.getColour())))
        holder.iconview.setImageResource(iconpicker.getIcon())
        holder.itemView.setOnClickListener {
            Toast.makeText(context, quizzes[position].title, Toast.LENGTH_SHORT).show()
            val intent = Intent(context, QustionActivity::class.java)
            intent.putExtra("DATE", quizzes[position].title)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return quizzes.size
    }

}