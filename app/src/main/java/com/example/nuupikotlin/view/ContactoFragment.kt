package com.example.nuupikotlin.view

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentCarameloBinding
import com.example.nuupikotlin.databinding.FragmentContactoBinding
import java.net.URI
import java.util.jar.Manifest

class ContactoFragment : Fragment() {

    private lateinit var binding: FragmentContactoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacto, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentContactoBinding.bind(view)

        //boton facebook
        binding.btnFacebook.setOnClickListener{
            val url = Uri.parse("https://www.facebook.com/nuupi.dulce")
            val intent = Intent(Intent.ACTION_VIEW,url)
            startActivity(intent)
        }
        //boton Instagram
        binding.btnInstagram.setOnClickListener{
            val url = Uri.parse("https://www.instagram.com/nuupimx")
            val intent = Intent(Intent.ACTION_VIEW,url)
            startActivity(intent)
        }
        //boton tiktok
        binding.btnTiktok.setOnClickListener{
            val url = Uri.parse("https://www.tiktok.com/@nuupimx")
            val intent = Intent(Intent.ACTION_VIEW,url)
            startActivity(intent)
        }

        //boton telefono
        binding.btnTelefono.setOnClickListener{
            if(ContextCompat.checkSelfPermission(requireContext(),android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                val miIntent = Intent(
                    Intent.ACTION_CALL,
                    Uri.parse("tel:5525103132")
                )
                startActivity(miIntent)
            }
            else{
                Toast.makeText(context,"Acepta el permiso y te atenderemos para tu pedido.",Toast.LENGTH_LONG).show()
                ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.CALL_PHONE),123)
            }
        }
    }
}