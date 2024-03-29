package com.example.nuupikotlin.ui.cuenta

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nuupikotlin.LoginActivity
import com.example.nuupikotlin.R
import com.example.nuupikotlin.databinding.FragmentDatoscuentaBinding
import com.example.nuupikotlin.utils.SharedPref
import com.github.dhaval2404.imagepicker.ImagePicker
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File

class DatosCuentaFragment : Fragment() {

    var circleImageUser: CircleImageView? = null
    private var imageFile: File? = null

    var sharedPref: SharedPref? = null

    private lateinit var binding: FragmentDatoscuentaBinding

    private val TAG="DatosCuentaFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datoscuenta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDatoscuentaBinding.bind(view)

        sharedPref = SharedPref(context as Activity)

        binding.btnAgregar.setOnClickListener {
            findNavController().navigate(R.id.action_nav_DatosCuenta_to_nav_Domicilio)
        }

        //Boton para cerrar sesion
        binding.btnCerrarSesion.setOnClickListener{logout()}

        circleImageUser = view.findViewById(R.id.circleImage_User)

        circleImageUser?.setOnClickListener{ selectImage() }

    }
    //Cerrar sesion
    private fun logout(){
        sharedPref?.remove("user")
        val i = Intent(context as Activity, LoginActivity::class.java)
        startActivity(i)
    }

    private val startImageResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result: ActivityResult ->

        val resultCode = result.resultCode
        val data = result.data

        if(resultCode == Activity.RESULT_OK){
            val fileUri = data?.data
            imageFile = File(fileUri?.path)
            circleImageUser?.setImageURI(fileUri)
        }
        else if(resultCode == ImagePicker.RESULT_ERROR){
            Toast.makeText(context,ImagePicker.getError(data),Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context,"Tarea se cancelo",Toast.LENGTH_LONG).show()
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