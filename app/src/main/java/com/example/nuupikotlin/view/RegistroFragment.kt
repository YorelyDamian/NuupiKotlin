package com.example.nuupikotlin.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentRegistroBinding

class RegistroFragment : Fragment() {

    val TAG = "RegistroFragment"

    private lateinit var binding: FragmentRegistroBinding

    var editTextNombre: EditText?= null
    var editTextApellidoP: EditText?= null
    var editTextApellidoM: EditText?= null
    var editTextTel: EditText?= null
    var editTextCorreo: EditText?= null
    var editTextPassword: EditText?= null
    var editTextConPassword: EditText?= null
    var editTextNacimiento: EditText?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextNombre = view.findViewById(R.id.txtNombre)
        editTextApellidoP = view.findViewById(R.id.txtApellidoP)
        editTextApellidoM = view.findViewById(R.id.txtApellidoM)
        editTextTel = view.findViewById(R.id.txtNumero)
        editTextCorreo = view.findViewById(R.id.txtCorreoE)
        editTextPassword = view.findViewById(R.id.txtContrasenia)
        editTextConPassword = view.findViewById(R.id.txtCcontrasenia)
        editTextNacimiento = view.findViewById(R.id.txtFechaNacimiento)

        binding = FragmentRegistroBinding.bind(view)

        binding.btnAceptar.setOnClickListener {
            registro()
            findNavController().navigate(R.id.action_nav_Registro_to_nav_Domicilio)
        }
    }

    private fun registro(){
        val nombre = editTextNombre?.text.toString()
        val apellidoP = editTextApellidoP?.text.toString()
        val apellidoM = editTextApellidoM?.text.toString()
        val telefono = editTextTel?.text.toString()
        val email = editTextCorreo?.text.toString()
        val password = editTextPassword?.text.toString()
        val cPassword = editTextConPassword?.text.toString()
        val fecha = editTextNacimiento?.text.toString()

        Toast.makeText(activity, "Tu nombre es: $nombre", Toast.LENGTH_LONG).show()
        Toast.makeText(activity, "Primer Apellido: $apellidoP", Toast.LENGTH_LONG).show()
        Toast.makeText(activity, "Segundo Apellido: $apellidoM", Toast.LENGTH_LONG).show()
        Toast.makeText(activity, "Numero de telefono: $telefono", Toast.LENGTH_LONG).show()
        Toast.makeText(activity, "El email es: $email", Toast.LENGTH_LONG).show()
        Toast.makeText(activity, "El password es: $password", Toast.LENGTH_LONG).show()
        Toast.makeText(activity, "Confirmar la contraseña: $cPassword", Toast.LENGTH_LONG).show()
        Toast.makeText(activity, "Fecha de nacimiento: $fecha", Toast.LENGTH_LONG).show()

        Log.d(TAG,"Nombre: $nombre")
        Log.d(TAG,"Primer apellido: $apellidoP")
        Log.d(TAG,"Segundo apellido: $apellidoM")
        Log.d(TAG,"Telefono: $telefono")
        Log.d(TAG,"Correo: $email")
        Log.d(TAG,"Password: $password")
        Log.d(TAG,"Confirmar Contraseña: $cPassword")
        Log.d(TAG,"Fecha de nacimiento: $fecha")
    }

}