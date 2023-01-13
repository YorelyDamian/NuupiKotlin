package com.example.nuupikotlin.administrador

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.nuupikotlin.LoginActivity
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentDatoscuentaBinding
import com.example.nuupikotlin.utils.SharedPref

class AdminActivity : AppCompatActivity() {
    private val TAG="AdminActivity"

    var sharedPref: SharedPref? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        sharedPref = SharedPref(this)

        val btnCerrar = findViewById<Button>(R.id.btnCerrarSesion)
        btnCerrar.setOnClickListener {
            logout()
        }
    }
    private fun logout(){
        sharedPref?.remove("user")
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
    }

}