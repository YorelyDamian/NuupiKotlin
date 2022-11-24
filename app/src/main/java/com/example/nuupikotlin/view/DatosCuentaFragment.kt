package com.example.nuupikotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentDatoscuentaBinding

class DatosCuentaFragment : Fragment() {

    private lateinit var binding: FragmentDatoscuentaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datoscuenta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDatoscuentaBinding.bind(view)

        binding.btnCambiar.setOnClickListener {
            findNavController().navigate(R.id.action_nav_DatosCuenta_to_nav_Contrasenia)
        }

        binding.btnAgregar.setOnClickListener {
            findNavController().navigate(R.id.action_nav_DatosCuenta_to_nav_Domicilio)
        }

    }

}