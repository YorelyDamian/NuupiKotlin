package com.example.nuupikotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentDisenioBinding

class DisenioFragment : Fragment() {

    private lateinit var binding: FragmentDisenioBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_disenio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDisenioBinding.bind(view)

        //boton caramelo
        binding.btnCaramelo.setOnClickListener {
            findNavController().navigate(R.id.action_nav_Disenio_to_nav_Caramelo)
        }

        //boton paleta
        binding.btnPaleta.setOnClickListener {
            findNavController().navigate(R.id.action_nav_Disenio_to_nav_Paleta)
        }

    }

}