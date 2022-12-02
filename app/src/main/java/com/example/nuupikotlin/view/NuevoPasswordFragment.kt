package com.example.nuupikotlin.view

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentIniciarSesionBinding
import com.example.nuupikotlin.databinding.FragmentNuevoPasswordBinding

class NuevoPasswordFragment : Fragment() {

    private lateinit var binding: FragmentNuevoPasswordBinding

    var editTextCorreoN: EditText?= null
    var editTextPassword: EditText?= null
    var editTextPasswordNuevo: EditText?= null
    var buttonGuardar: Button?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nuevo_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextCorreoN = view.findViewById(R.id.txtCorreoN)
        editTextPassword = view.findViewById(R.id.txtPassword)
        editTextPasswordNuevo = view.findViewById(R.id.txtPasswordNuevo)
        buttonGuardar = view.findViewById(R.id.btn_Guardar)

        buttonGuardar?.setOnClickListener { nuevoPass() }

        binding = FragmentNuevoPasswordBinding.bind(view)

    }

    private fun nuevoPass(){
        val correo = editTextCorreoN?.text.toString()
        val password = editTextPassword?.text.toString()
        val passwordN = editTextPasswordNuevo?.text.toString()

        if (validateCuenta(correo,password,passwordN)){
            Toast.makeText(activity, "Nueva contraseña guardada", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(activity, "Datos incorrectos", Toast.LENGTH_LONG).show()
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
            Toast.makeText(activity, "Tu contraseña no coincide", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

}