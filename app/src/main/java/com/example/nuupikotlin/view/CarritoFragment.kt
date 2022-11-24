package com.example.nuupikotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentCarameloBinding
import com.example.nuupikotlin.databinding.FragmentCarritoBinding

class CarritoFragment : Fragment() {

    private lateinit var binding: FragmentCarritoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carrito, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCarritoBinding.bind(view)

        binding.btnSeguirPedido.setOnClickListener {
            findNavController().navigate(R.id.action_nav_carrito_to_nav_Pago)
        }

    }

}