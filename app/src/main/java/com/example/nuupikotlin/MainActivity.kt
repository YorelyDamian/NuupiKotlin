package com.example.nuupikotlin

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.nuupikotlin.databinding.ActivityMainBinding
import com.example.nuupikotlin.models.User
import com.example.nuupikotlin.ui.buscador.BuscadorFragment
import com.example.nuupikotlin.utils.SharedPref
import com.example.nuupikotlin.view.CarritoFragment
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    val btnBus = BuscadorFragment()
    val btnCom = CarritoFragment()
    var sharedPref: SharedPref? = null

    private val TAG="MainActivity"

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = SharedPref(this)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_DatosCuenta, R.id.nav_buscador,R.id.nav_compras,R.id.nav_notificaciones
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val txtBuscador : TextView = findViewById(R.id.txtBuscar)
        val btnCarrito : ImageButton = findViewById(R.id.btncarrito_compras)

        txtBuscador.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_content_main, btnBus)
                addToBackStack(null)
                commit()
            }
        }

        btnCarrito.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.nav_host_fragment_content_main, btnCom)
                addToBackStack(null)
                commit()
            }
        }

        getUserFromSession()

    }

    //Metodo para guardar datos de inicio de sesion
    private fun getUserFromSession(){
        //val sharedPref = SharedPref(this as Activity)
        //val sharedPref = SharedPref(this)
        val gson = Gson()

        if(!sharedPref?.getData("user").isNullOrBlank()){
            //si el usuario existe en sesion
            val user = gson.fromJson(sharedPref?.getData("user"), User::class.java)
            Log.d(TAG,"Usuario: $user")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}