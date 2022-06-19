package com.example.assignment.utils

import android.app.Activity
import android.content.Intent

fun Activity.intent(destination:Class<*>){
    val intent = Intent(this,destination)
    startActivity(intent)
}