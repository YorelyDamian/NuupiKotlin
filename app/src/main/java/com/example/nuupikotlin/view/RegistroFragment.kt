package com.example.nuupikotlin.view

import android.os.Bundle
import android.text.TextUtils
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

        if (validateRegistro(nombre,apellidoP,apellidoM,telefono,email,password,cPassword,fecha)){
            Toast.makeText(activity, "Datos Guardados exitosamente", Toast.LENGTH_LONG).show()
        }

        Log.d(TAG,"Nombre: $nombre")
        Log.d(TAG,"Primer apellido: $apellidoP")
        Log.d(TAG,"Segundo apellido: $apellidoM")
        Log.d(TAG,"Telefono: $telefono")
        Log.d(TAG,"Correo: $email")
        Log.d(TAG,"Password: $password")
        Log.d(TAG,"Confirmar Contraseña: $cPassword")
        Log.d(TAG,"Fecha de nacimiento: $fecha")
    }

    fun String.isEmailValid(): Boolean{
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()

    }

    private fun validateRegistro(
        nombre: String,
        apellidoP:String,
        apellidoM: String,
        telefono:String,
        email: String,
        password:String,
        cPassword:String,
        fecha:String
        ): Boolean{

        if(nombre.isBlank()){
            Toast.makeText(activity, "Ingresa nombre de usuario", Toast.LENGTH_LONG).show()
            return false
        }
        if(apellidoP.isBlank()){
            Toast.makeText(activity, "Ingresa tu apellido paterno", Toast.LENGTH_LONG).show()
            return false
        }
        if(apellidoM.isBlank()){
            Toast.makeText(activity, "Ingresa tu apellido materno", Toast.LENGTH_LONG).show()
            return false
        }
        if(telefono.isBlank()){
            Toast.makeText(activity, "Ingresa un número telefonico", Toast.LENGTH_LONG).show()
            return false
        }
        if(email.isBlank()){
            Toast.makeText(activity, "Debes ingresar un correo electronico", Toast.LENGTH_LONG).show()
            return false
        }
        if(password.isBlank()){
            Toast.makeText(activity, "Ingresa tu contraseña", Toast.LENGTH_LONG).show()
            return false
        }
        if(cPassword.isBlank()){
            Toast.makeText(activity, "Falta la confirmacion de la contraseña", Toast.LENGTH_LONG).show()
            return false
        }
        if(fecha.isBlank()){
            Toast.makeText(activity, "Ingresa tu fecha de nacimiento", Toast.LENGTH_LONG).show()
            return false
        }

        if (!email.isEmailValid()){
            return false
        }
        if (!password.equals(cPassword)){
            Toast.makeText(activity, "Tu contraseña no coincide", Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }

}