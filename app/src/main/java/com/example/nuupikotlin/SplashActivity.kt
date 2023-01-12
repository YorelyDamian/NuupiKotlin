package com.example.nuupikotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Aqui puedo cambiar que vista me muestra primero, LoginActivity or saveImageActivity
        startActivity(Intent(this,LoginActivity::class.java))
    }
}