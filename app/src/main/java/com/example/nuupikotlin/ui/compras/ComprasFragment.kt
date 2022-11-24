package com.example.nuupikotlin.ui.compras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentComprasBinding

class ComprasFragment : Fragment() {

    private lateinit var binding: FragmentComprasBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compras, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentComprasBinding.bind(view)

        //Boton ir a productos
        binding.imgbtnProducto.setOnClickListener {
            findNavController().navigate(R.id.action_nav_compras_to_nav_Producto)
        }

    }
}