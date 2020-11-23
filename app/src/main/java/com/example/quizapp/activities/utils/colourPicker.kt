package com.example.quizapp.activities.utils

object ColorPicker{
    val colors= arrayOf(
  "#f0a0ff",
    "#bfc7cc",
    "#ffb6c1",
    "#e8eaee",
   "#53555a",
   "#625e5e" ,
    "#504b5d",
    "#9e909a",
    "#867581",
    "#000000",
   "#ffee88" ,
    "#b57170"
   )
    var currentColorIndex=0
    fun getColour():String{
       currentColorIndex=(currentColorIndex+1)% colors.size
        return colors[currentColorIndex]

    }
}