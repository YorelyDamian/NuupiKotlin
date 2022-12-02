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
import com.example.nuupikotlin.databinding.FragmentDomicilioBinding
import com.example.nuupikotlin.databinding.FragmentRegistroBinding

class DomicilioFragment : Fragment() {

    val TAG ="DomicilioFragment"

    private lateinit var binding: FragmentDomicilioBinding

    var editTextEstado: EditText?= null
    var editTextMunicipio: EditText?= null
    var editTextColonia: EditText?= null
    var editTextCodigoPostal: EditText?= null
    var editTextCallePrincipal: EditText?= null
    var editTextNumeroEx: EditText?= null
    var editTextCalleUno: EditText?= null
    var editTextCalleDos: EditText?= null
    var editTextReferencias: EditText?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_domicilio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextEstado = view.findViewById(R.id.txtEstado)
        editTextMunicipio = view.findViewById(R.id.txtMunicipio)
        editTextColonia = view.findViewById(R.id.txtColonia)
        editTextCodigoPostal = view.findViewById(R.id.txtCodigoP)
        editTextCallePrincipal = view.findViewById(R.id.txtCallePrincipal)
        editTextNumeroEx = view.findViewById(R.id.txtNumeroEx)
        editTextCalleUno = view.findViewById(R.id.txtCalleUno)
        editTextCalleDos = view.findViewById(R.id.txtCalleDos)
        editTextReferencias = view.findViewById(R.id.txtReferencias)

        binding = FragmentDomicilioBinding.bind(view)


        binding.btnGuardar.setOnClickListener {
            domicilio()
        }
    }

    private fun domicilio(){
        val estado = editTextEstado?.text.toString()
        val municipio = editTextMunicipio?.text.toString()
        val colonia = editTextColonia?.text.toString()
        val codigoP = editTextCodigoPostal?.text.toString()
        val callePri = editTextCallePrincipal?.text.toString()
        val numeroex = editTextNumeroEx?.text.toString()
        val calleUno = editTextCalleUno?.text.toString()
        val calleDos = editTextCalleDos?.text.toString()
        val referencias = editTextReferencias?.text.toString()

        if (validateDomicilio(estado,municipio,colonia,codigoP,callePri,numeroex,calleUno,calleDos,referencias)){
            Toast.makeText(activity, "Datos Guardados exitosamente", Toast.LENGTH_LONG).show()
        }

        Log.d(TAG,"Estado: $estado")
        Log.d(TAG,"Municipio: $municipio")
        Log.d(TAG,"Colonia: $colonia")
        Log.d(TAG,"Codigo Postal: $codigoP")
        Log.d(TAG,"Calle Principal: $callePri")
        Log.d(TAG,"Numero exterior: $numeroex")
        Log.d(TAG,"Calle uno: $calleUno")
        Log.d(TAG,"Calle dos: $calleDos")
        Log.d(TAG,"Referencias: $referencias")
    }

    private fun validateDomicilio(
        estado: String,
        municipio:String,
        colonia: String,
        codigoP:String,
        callePri: String,
        numeroex:String,
        calleUno:String,
        calleDos:String,
        referencias:String
    ): Boolean {

        if (estado.isBlank()) {
            Toast.makeText(activity, "Ingresa el estado de donde eres", Toast.LENGTH_LONG).show()
            return false
        }
        if (municipio.isBlank()) {
            Toast.makeText(activity, "Falta ingresar el municipio", Toast.LENGTH_LONG).show()
            return false
        }
        if (colonia.isBlank()) {
            Toast.makeText(activity, "Colonia en la que vives es ?", Toast.LENGTH_LONG).show()
            return false
        }
        if (codigoP.isBlank()) {
            Toast.makeText(activity, "Ingresa el codigo postal", Toast.LENGTH_LONG).show()
            return false
        }
        if (callePri.isBlank()) {
            Toast.makeText(activity, "Ingresa el nombre de la calle principal", Toast.LENGTH_LONG)
                .show()
            return false
        }
        if (numeroex.isBlank()) {
            Toast.makeText(activity, "Si no tienes numero exterior coloca S/N", Toast.LENGTH_LONG).show()
            return false
        }
        if (calleUno.isBlank()) {
            Toast.makeText(activity, "Ingresa una calle", Toast.LENGTH_LONG)
                .show()
            return false
        }
        if (calleDos.isBlank()) {
            Toast.makeText(activity, "Ingresa una calle", Toast.LENGTH_LONG).show()
            return false
        }
        if (referencias.isBlank()) {
            Toast.makeText(activity, "Ingresa una referencia", Toast.LENGTH_LONG).show()
            return false
        }

    return true
    }

}