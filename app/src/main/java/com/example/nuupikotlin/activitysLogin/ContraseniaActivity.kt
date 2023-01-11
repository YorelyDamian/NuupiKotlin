package com.example.nuupikotlin.activitysLogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nuupikotlin.R
class ContraseniaActivity : AppCompatActivity() {

    var editTextCorreoN: EditText?= null
    var editTextPassword: EditText?= null
    var editTextPasswordNuevo: EditText?= null
    var buttonGuardar: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrasenia)

        editTextCorreoN = findViewById(R.id.txtCorreoN)
        editTextPassword = findViewById(R.id.txtPassword)
        editTextPasswordNuevo = findViewById(R.id.txtPasswordNuevo)
        buttonGuardar = findViewById(R.id.btn_Guardar)

        buttonGuardar?.setOnClickListener { nuevoPass() }

    }

    private fun nuevoPass(){
        val correo = editTextCorreoN?.text.toString()
        val password = editTextPassword?.text.toString()
        val passwordN = editTextPasswordNuevo?.text.toString()

        if (validateCuenta(correo,password,passwordN)){
            Toast.makeText(this, "Nueva contraseña guardada", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show()
        }

        Log.d("NuevoPasswordFragment","El email es: $correo")
        Log.d("NuevoPasswordFragment","El password es: $password")
        Log.d("NuevoPasswordFragment","Confirmacion de password es: $passwordN")
    }

    fun String.isEmailValid(): Boolean{
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()

    }

    private fun validateCuenta(email: String, password:String, passwordN: String): Boolean{
        if(email.isBlank()){
            return false
        }
        if (password.isBlank()){
            return false
        }
        if (passwordN.isBlank()){
            return false
        }
        if (!email.isEmailValid()){
            return false
        }
        if (!password.equals(passwordN)){
            Toast.makeText(this, "Tu contraseña no coincide", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }


}