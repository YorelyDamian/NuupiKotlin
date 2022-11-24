package com.example.nuupikotlin.ui.cuenta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentCuentaBinding

class CuentaFragment : Fragment() {

    private lateinit var binding : FragmentCuentaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuenta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCuentaBinding.bind(view)

        //boton ir a login
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_nav_cuenta_to_nav_iniciarsesion)
        }

    }
}