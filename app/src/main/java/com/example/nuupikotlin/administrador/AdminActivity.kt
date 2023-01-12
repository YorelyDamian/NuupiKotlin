package com.example.nuupikotlin.administrador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nuupikotlin.R
import com.example.nuupikotlin.models.User
import com.example.nuupikotlin.utils.SharedPref
import com.google.gson.Gson

class AdminActivity : AppCompatActivity() {
    private val TAG="AdminActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

    }

}