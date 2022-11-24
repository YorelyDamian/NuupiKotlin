package com.example.nuupikotlin.ui.iniciarsesion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentIniciarSesionBinding

class IniciarSesionFragment : Fragment() {

    private lateinit var binding: FragmentIniciarSesionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iniciar_sesion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
}