package com.example.nuupikotlin.view

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.DatePickerFragment
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentRegistroBinding
import com.example.nuupikotlin.models.ResponseHttp
import com.example.nuupikotlin.models.User
import com.example.nuupikotlin.providers.UsersProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    var usersProvider = UsersProvider()

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
            findNavController().navigate(R.id.action_nav_Registro_to_nav_iniciarsesion)
        }
        editTextNacimiento?.setOnClickListener{
            showDatePickerDialog()
        }
    }

    //Para la fecha de nacimiento

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(parentFragmentManager,"datePicker")
    }

    fun onDateSelected(day:Int,month:Int,year:Int){
        editTextNacimiento?.setText("$year-$month-$day")
    }
//Fin de la fecha de nacimiento

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
            val user = User(
                psnombreUsuario = nombre,
                psapellido1Usuario = apellidoP,
                psapellido2Usuario = apellidoM,
                pstelefonoUsuario = telefono,
                psPemailUsu = email,
                pscontraUsuario = password,
                psconfirmaContraUsuario = cPassword,
                psfechaNacimiento = fecha
            )
            usersProvider.register(user)?.enqueue(object: Callback<ResponseHttp>{
                override fun onResponse(call: Call<ResponseHttp>, response: Response<ResponseHttp>) {
                    Toast.makeText(activity,response.body()?.message, Toast.LENGTH_LONG).show()
                    Log.d(TAG, "Response:${response}")
                    Log.d(TAG,"Body:${response.body()}")
                }

                override fun onFailure(call: Call<ResponseHttp>, t: Throwable) {
                    Log.d(TAG, "SE PRODUJO UN ERROR DE REGISTRO ${t.message}")
                    Toast.makeText(activity,"SE PRODUJO UN ERROR DE REGISTRO ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    fun String.isEmailValid(): Boolean{
        return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()

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