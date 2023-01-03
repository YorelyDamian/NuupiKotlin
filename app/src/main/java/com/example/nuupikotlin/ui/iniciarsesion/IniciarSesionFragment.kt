package com.example.nuupikotlin.ui.iniciarsesion

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentIniciarSesionBinding
import com.example.nuupikotlin.models.ResponseHttp
import com.example.nuupikotlin.providers.UsersProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IniciarSesionFragment : Fragment() {

    private lateinit var binding: FragmentIniciarSesionBinding

    var editTextEmail: EditText?= null
    var editTextPassword: EditText?= null
    var buttonLogin: Button?= null
    var usersProvider = UsersProvider()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iniciar_sesion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextEmail = view.findViewById(R.id.txtCorreo)
        editTextPassword = view.findViewById(R.id.txtPassword)
        buttonLogin = view.findViewById(R.id.btnIniciar)

        buttonLogin?.setOnClickListener { login() }

        binding = FragmentIniciarSesionBinding.bind(view)

        //Boton registro usuario
        binding.btnRegistro.setOnClickListener {
            findNavController().navigate(R.id.action_nav_iniciarsesion_to_nav_Registro)
        }

        //Boton Cambiar Contraseña
        binding.btnOlvideContrasenia.setOnClickListener {
            findNavController().navigate(R.id.action_nav_iniciarsesion_to_nav_Contrasenia)
        }
    }

    private fun login(){
        val email = editTextEmail?.text.toString()
        val password = editTextPassword?.text.toString()

        if (validateLogin(email,password)){

            usersProvider.login(email, password)?.enqueue(object: Callback<ResponseHttp>{

                override fun onResponse(call: Call<ResponseHttp>, response: Response<ResponseHttp>){
                    Log.d("IniciarSesionFragment","Response:${response.body()}")
                    if(response.body()?.inSuccess==true){
                        Toast.makeText(activity, response.body()?.message, Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(activity,"Los datos son incorrectos",Toast.LENGTH_LONG).show()
                    }

                }

                override fun onFailure(call: Call<ResponseHttp>, t: Throwable) {
                    Log.d("IniciarSesionFragment","Hubo un error ${t.message}")
                    Toast.makeText(activity, "Hubo un error ${t.message}", Toast.LENGTH_LONG).show()
                }

            })

        }else{
            Toast.makeText(activity, "Datos incorrectos", Toast.LENGTH_LONG).show()
        }

        //Log.d("IniciarSesionFragment","El email es: $email")
        //Log.d("IniciarSesionFragment","El password es: $password")
    }

    fun String.isEmailValid(): Boolean{
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun validateLogin(email: String, password:String): Boolean{
        if(email.isBlank()){
            return false
        }
        if (password.isBlank()){
            return false
        }
        if (!email.isEmailValid()){
            return false
        }
        return true
    }

}