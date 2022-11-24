package com.example.nuupikotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentCarameloBinding

class CarameloFragment : Fragment() {

    private lateinit var binding: FragmentCarameloBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?):
            View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_caramelo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCarameloBinding.bind(view)

        //boton Hacer compra
        binding.btnComprar.setOnClickListener {
            findNavController().navigate(R.id.action_nav_Caramelo_to_nav_Pago)
        }

        val spModelo : Spinner = view.findViewById(R.id.sp_Modelo)
        ArrayAdapter.createFromResource(requireContext(), R.array.modelo, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spModelo.adapter = adapter
        }

        val spSabor : Spinner = view.findViewById(R.id.sp_Sabor)
        ArrayAdapter.createFromResource(requireContext(), R.array.sabor, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spSabor.adapter = adapter
        }

        val spColor : Spinner = view.findViewById(R.id.sp_Color)
        ArrayAdapter.createFromResource(requireContext(), R.array.color, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spColor.adapter = adapter
        }

    }

}