package com.example.quizapp.activities.models

data class Quiz(
        var id:String="",
        var title:String="",
        var question:MutableMap<String,Qustions> = mutableMapOf()
)