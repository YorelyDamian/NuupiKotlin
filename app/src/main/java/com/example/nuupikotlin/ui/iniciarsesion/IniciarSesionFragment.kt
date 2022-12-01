package com.example.nuupikotlin.ui.iniciarsesion

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentIniciarSesionBinding

class IniciarSesionFragment : Fragment() {

    private lateinit var binding: FragmentIniciarSesionBinding

    var editTextEmail: EditText?= null
    var editTextPassword: EditText?= null
    var buttonLogin: Button?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iniciar_sesion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextEmail = view.findViewById(R.id.txtCorreo)
        editTextPassword = view.findViewById(R.id.txtPassword)
        buttonLogin = view.findViewById(R.id.btnIniciar)

        buttonLogin?.setOnClickListener { login() }

        binding = FragmentIniciarSesionBinding.bind(view)

        //Boton registro usuario
        binding.btnRegistro.setOnClickListener {
            findNavController().navigate(R.id.action_nav_iniciarsesion_to_nav_Registro)
        }

        //Boton Cambiar Contraseña
        binding.btnOlvideContrasenia.setOnClickListener {
            findNavController().navigate(R.id.action_nav_iniciarsesion_to_nav_Contrasenia)
        }
    }

    private fun login(){
        val email = editTextEmail?.text.toString()
        val password = editTextPassword?.text.toString()

        Toast.makeText(activity, "El email es: $email", Toast.LENGTH_LONG).show()
        Toast.makeText(activity, "El password es: $password", Toast.LENGTH_LONG).show()

        Log.d("IniciarSesionFragment","El email es: $email")
        Log.d("IniciarSesionFragment","El password es: $password")
    }
}