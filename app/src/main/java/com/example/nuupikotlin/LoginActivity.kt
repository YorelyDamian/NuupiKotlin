package com.example.nuupikotlin

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nuupikotlin.activitysLogin.ContraseniaActivity
import com.example.nuupikotlin.activitysLogin.RegistroActivity
import com.example.nuupikotlin.administrador.AdminActivity
import com.example.nuupikotlin.models.ResponseHttp
import com.example.nuupikotlin.models.User
import com.example.nuupikotlin.providers.UsersProvider
import com.example.nuupikotlin.utils.SharedPref
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    var editTextEmail: EditText?= null
    var editTextPassword: EditText?= null
    var btnRegistro: Button?= null
    var btnContrasenia: Button?= null
    var usersProvider = UsersProvider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextEmail = findViewById(R.id.txtCorreo)
        editTextPassword = findViewById(R.id.txtPassword)
        btnRegistro= findViewById(R.id.btn_registro)
        btnContrasenia= findViewById(R.id.btn_olvideContrasenia)

        //Boton Iniciar Sesion
        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        btnIniciar.setOnClickListener{
            login()
        }

        //Boton registro usuario
        btnRegistro?.setOnClickListener{gotoViewRegistro()}

        //Boton Cambiar Contraseña
        btnContrasenia?.setOnClickListener{gotoViewContrasenia()}

        getUserFromSession()
    }

    //Metodo para dirijir a vista Registro
    private fun gotoViewRegistro(){
        val i = Intent(this,RegistroActivity::class.java)
        startActivity(i)
    }
    //Metodo para dirijir a vista Nuevo Password
    private  fun gotoViewContrasenia(){
        val i = Intent(this,ContraseniaActivity::class.java)
        startActivity(i)
    }

    private fun login(){
        val email = editTextEmail?.text.toString()
        val password = editTextPassword?.text.toString()

        if (isValidForm(email,password)){

            usersProvider.login(email, password)?.enqueue(object: Callback<ResponseHttp> {

                override fun onResponse(
                    call: Call<ResponseHttp>,
                    response: Response<ResponseHttp>
                ){
                    Log.d("LoginActivity","Response:${response.body()}")

                    if(response.body()?.inSuccess == true){

                        saveUserInSession(response.body()?.data.toString())
                        Toast.makeText(this@LoginActivity, response.body()?.message, Toast.LENGTH_LONG).show()

                    }
                    else{
                        Toast.makeText(this@LoginActivity,"Los datos son incorrectos", Toast.LENGTH_LONG).show()
                    }

                }

                override fun onFailure(call: Call<ResponseHttp>, t: Throwable) {
                    //Log.d("IniciarSesionFragment","Hubo un error ${t.message}")
                    Toast.makeText(this@LoginActivity, "Hubo un error ${t.message}", Toast.LENGTH_LONG).show()
                }

            })

        }else{
            Toast.makeText(this, "Ingresa todos los datos", Toast.LENGTH_LONG).show()
        }

        //Log.d("IniciarSesionFragment","El email es: $email")
        //Log.d("IniciarSesionFragment","El password es: $password")
    }

    //Vista que mostrara despues de iniciar sesion si es un cliente
    private fun gotoClientHome(){
        val i = Intent(this, MainActivity::class.java)
        i.flags = FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK //Eliminar el historial de pantallas
        startActivity(i)
    }

    //Vista que mostrara despues de iniciar sesion si es un admin
    private fun gotoAdminHome(){
        val i = Intent(this, AdminActivity::class.java)
        i.flags = FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK //Eliminar el historial de pantallas
        startActivity(i) //error aqui
    }

    //Vista que mostrara si el usuario tiene dos roles
    private fun gotoSelectRol(){
        val i = Intent(this, SelectRolesActivity::class.java)
        i.flags = FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK //Eliminar el historial de pantallas
        startActivity(i)
    }

    //Metodo para guardar los datos del usuario
    private fun saveUserInSession(data:String){

        val sharedPref = SharedPref(this)
        val gson = Gson()
        val user = gson.fromJson(data, User::class.java)
        sharedPref.save("user", user)

        if(user.roles?.size!! > 1){//En caso de que el usuario registrado tenga mas de un rol
            gotoSelectRol()
        }else{//En caso de que tenga un rol y sea cliente
            gotoClientHome()
        }

    }

    //
    private fun getUserFromSession(){
        val sharedPref = SharedPref(this)
        val gson = Gson()

        if(!sharedPref.getData("user").isNullOrBlank()){
            //si el usuario existe en sesion
            val user=gson.fromJson(sharedPref.getData("user"),User::class.java)
            //log.d(tag,"Usuario:$user")

            if(!sharedPref.getData("rol").isNullOrBlank()){

                //Si el usuario seleccionao el rol
                val rol = sharedPref.getData("rol")?.replace("\"","")

                if(rol == "ADMIN"){
                    gotoAdminHome() //error aqui
                }
                else if(rol == "CLIENTE"){
                    gotoClientHome()
                }
            }
            else{
                gotoClientHome()
            }
            //gotoClientHome()
        }
    }

    //Validacion del Email
    fun String.isEmailValid(): Boolean{
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    //Validar que los campos sean llenados
    private fun isValidForm(email: String, password:String): Boolean{
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