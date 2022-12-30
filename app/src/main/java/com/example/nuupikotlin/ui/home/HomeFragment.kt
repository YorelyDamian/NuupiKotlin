package com.example.nuupikotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated( view:View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        //Boton productos
        binding.btnProducto.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_producto)

        }
        //Boton diseño
        binding.btnMidisenio.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_disenio)

        }
        //Boton Contactos
        binding.btnContacto.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_contacto)
        }
        //Boton Guia
        binding.btnGuia.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_guia)
        }

    }

}