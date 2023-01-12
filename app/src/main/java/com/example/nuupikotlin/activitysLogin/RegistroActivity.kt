package com.example.nuupikotlin.activitysLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nuupikotlin.*
import com.example.nuupikotlin.models.ResponseHttp
import com.example.nuupikotlin.models.User
import com.example.nuupikotlin.providers.UsersProvider
import com.example.nuupikotlin.utils.SharedPref
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistroActivity : AppCompatActivity() {

    val TAG = "RegistroActivity"

    var editTextNombre: EditText?= null
    var editTextApellidoP: EditText?= null
    var editTextApellidoM: EditText?= null
    var editTextTel: EditText?= null
    var editTextCorreo: EditText?= null
    var editTextPassword: EditText?= null
    var editTextConPassword: EditText?= null
    var editTextNacimiento: EditText?= null

    var usersProvider = UsersProvider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        editTextNombre = findViewById(R.id.txtNombre)
        editTextApellidoP = findViewById(R.id.txtApellidoP)
        editTextApellidoM = findViewById(R.id.txtApellidoM)
        editTextTel = findViewById(R.id.txtNumero)
        editTextCorreo = findViewById(R.id.txtCorreoE)
        editTextPassword = findViewById(R.id.txtContrasenia)
        editTextConPassword = findViewById(R.id.txtCcontrasenia)
        editTextNacimiento = findViewById(R.id.txtFechaNacimiento)

        //RealizarRegistro
        val btnAceptar = findViewById<Button>(R.id.btn_Aceptar)
        btnAceptar.setOnClickListener {
            registro()
        }

        editTextNacimiento?.setOnClickListener{
            showDatePickerDialog()
        }

    }

    //Para la fecha de nacimiento

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager,"datePicker")
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
            usersProvider.register(user)?.enqueue(object: Callback<ResponseHttp> {
                override fun onResponse(call: Call<ResponseHttp>, response: Response<ResponseHttp>) {
                    if(response.body()?.inSuccess==true){
                        saveUserInSession(response.body()?.data.toString())
                        gotoImage()
                    }

                    Toast.makeText(this@RegistroActivity,response.body()?.message, Toast.LENGTH_LONG).show()
                    Log.d(TAG, "Response:${response}")
                    Log.d(TAG,"Body:${response.body()}")
                }

                override fun onFailure(call: Call<ResponseHttp>, t: Throwable) {
                    Log.d(TAG, "SE PRODUJO UN ERROR DE REGISTRO ${t.message}")
                    Toast.makeText(this@RegistroActivity,"SE PRODUJO UN ERROR DE REGISTRO ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    //Vista que mostrara despues de iniciar sesion si no quiere agregar una imagen
    private fun gotoImage(){
        val i = Intent(this, SaveImageActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK //Eliminar el historial de pantallas
        startActivity(i)
    }

    //Metodo para guardar los datos del usuario
    private fun saveUserInSession(data:String){

        val sharedPref = SharedPref(this)
        val gson = Gson()
        val user = gson.fromJson(data, User::class.java)
        sharedPref.save("user", user)

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
            Toast.makeText(this, "Ingresa nombre de usuario", Toast.LENGTH_LONG).show()
            return false
        }
        if(apellidoP.isBlank()){
            Toast.makeText(this, "Ingresa tu apellido paterno", Toast.LENGTH_LONG).show()
            return false
        }
        if(apellidoM.isBlank()){
            Toast.makeText(this, "Ingresa tu apellido materno", Toast.LENGTH_LONG).show()
            return false
        }
        if(telefono.isBlank()){
            Toast.makeText(this, "Ingresa un número telefonico", Toast.LENGTH_LONG).show()
            return false
        }
        if(email.isBlank()){
            Toast.makeText(this, "Debes ingresar un correo electronico", Toast.LENGTH_LONG).show()
            return false
        }
        if(password.isBlank()){
            Toast.makeText(this, "Ingresa tu contraseña", Toast.LENGTH_LONG).show()
            return false
        }
        if(cPassword.isBlank()){
            Toast.makeText(this, "Falta la confirmacion de la contraseña", Toast.LENGTH_LONG).show()
            return false
        }
        if(fecha.isBlank()){
            Toast.makeText(this, "Ingresa tu fecha de nacimiento", Toast.LENGTH_LONG).show()
            return false
        }

        if (!email.isEmailValid()){
            return false
        }
        if (!password.equals(cPassword)){
            Toast.makeText(this, "Tu contraseña no coincide", Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }


}