package com.example.nuupikotlin.administrador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.nuupikotlin.LoginActivity
import com.example.nuupikotlin.R
import com.example.nuupikotlin.utils.SharedPref

class AdminActivity : AppCompatActivity() {

    var btnNuevo: Button?= null
    var btnEntregado: Button?= null
    var sharedPref: SharedPref? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        sharedPref = SharedPref(this)

        btnNuevo= findViewById(R.id.btn_Pedidos)
        btnEntregado= findViewById(R.id.btn_Entregados)

        //Cerrar sesión
        val btnCerrar = findViewById<Button>(R.id.btnCerrarSesion)
        btnCerrar.setOnClickListener {
            logout()
        }
        //Vista Pedidos Nuevos
        btnNuevo?.setOnClickListener{ pedidosNuevos() }

        //Vista pedidos entregados
        btnEntregado?.setOnClickListener{ pedidosEntregados() }

    }

    private fun pedidosNuevos(){
        val i = Intent(this,PedidosNuevosActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
    }

    private fun pedidosEntregados(){
        val i = Intent(this,PedidosEntregadosActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
    }

    private fun logout(){
        sharedPref?.remove("user")
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
    }

}