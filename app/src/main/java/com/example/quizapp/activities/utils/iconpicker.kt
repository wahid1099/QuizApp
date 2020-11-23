package com.example.quizapp.activities.utils

import com.example.quizapp.R


object iconpicker {
    val icons = arrayOf(
            R.drawable.ic_iconfinder_ebook_e_learning_education_plant_online_4288578,
            R.drawable.iconfinder_student_309036,
            R.drawable.ic_iconfinder_ebook_e_learning_education_plant_online_4288578,
            R.drawable.ic_iconfinder_elearning_ebook_education_online_skill_4288589,
            R.drawable.ic_iconfinder_book_3069185
    )
    var currentIcon = 0
    fun getIcon(): Int {
        currentIcon = (currentIcon + 1) % icons.size
        return icons[currentIcon]

    }
}