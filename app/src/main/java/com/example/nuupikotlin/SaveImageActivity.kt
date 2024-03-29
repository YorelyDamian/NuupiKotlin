package com.example.nuupikotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.nuupikotlin.models.ResponseHttp
import com.example.nuupikotlin.models.User
import com.example.nuupikotlin.providers.UsersProvider
import com.example.nuupikotlin.utils.SharedPref
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.gson.Gson
import de.hdodenhof.circleimageview.CircleImageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class SaveImageActivity : AppCompatActivity() {

    val TAG = "SaveImageActivity"

    var circleImage: CircleImageView? = null
    var btnNext: Button?= null
    var btnConfirm: Button?= null
    private var imageFile: File? = null
    var usersProvider = UsersProvider()
    var user: User? = null
    var sharedPref: SharedPref? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_image)
        getUserFromSession()
        sharedPref = SharedPref(this)
        circleImage = findViewById(R.id.circleImage)
        btnNext = findViewById(R.id.btnSaltarPaso)
        btnConfirm = findViewById(R.id.btnConfirmarImage)

        circleImage?.setOnClickListener{ selectImage() }
        btnNext?.setOnClickListener{gotoClientHome()}
        btnConfirm?.setOnClickListener{saveImage()}

    }

    //Metodo para guardar la imagen
    private fun saveImage(){
        if (imageFile != null && user != null){
            usersProvider.update(imageFile!!, user!!)?.enqueue(object: Callback<ResponseHttp>{
                override fun onResponse(call: Call<ResponseHttp>, response: Response<ResponseHttp>) {
                    Log.d(TAG,"RESPONSE:$response")
                    Log.d(TAG,"BODY:${response.body()}")
                }

                override fun onFailure(call: Call<ResponseHttp>, t: Throwable) {
                    Log.d(TAG,"Error: ${t.message}")
                    Toast.makeText(this@SaveImageActivity,"Error: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
        }
        else{
            Toast.makeText(this, "La imagen no puede ser nula ni tampoco los datos de sesion del usuario", Toast.LENGTH_LONG).show()
        }
    }

    //Vista que mostrara despues de iniciar sesion si no quiere agregar una imagen
    private fun gotoClientHome(){
        val i = Intent(this, MainActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK //Eliminar el historial de pantallas
        startActivity(i)
    }

    //Metodo para guardar datos de inicio de sesion
    private fun getUserFromSession(){
        val gson = Gson()
        if(!sharedPref?.getData("user").isNullOrBlank()){
            //si el usuario existe en sesion
            user = gson.fromJson(sharedPref?.getData("user"), User::class.java)
        }
    }

    private val startImageResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->

        val resultCode = result.resultCode
        val data = result.data

        if(resultCode == Activity.RESULT_OK){
            val fileUri = data?.data
            imageFile = File(fileUri?.path)
            circleImage?.setImageURI(fileUri)
        }
        else if(resultCode == ImagePicker.RESULT_ERROR){
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Tarea se cancelo", Toast.LENGTH_LONG).show()
        }

    }

    private fun selectImage(){
        ImagePicker.with(this)
            .crop()	    			//Crop image(Optional), Check Customization for more option
            .compress(1024)			//Final image size will be less than 1 MB(Optional)
            .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
            .createIntent { intent ->
                startImageResult.launch(intent)
            }
    }

}