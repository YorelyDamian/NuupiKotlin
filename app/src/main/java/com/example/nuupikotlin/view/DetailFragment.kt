package com.example.nuupikotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.nuupikotlin.R
import java.net.URI

class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)

        val getData = activity?.intent?.getParcelableExtra<DataClass>("android")
        if (getData != null){
            val detail_Nombre: TextView? = view?.findViewById(R.id.detailNombre)
            val detail_Image:ImageView? = view?.findViewById(R.id.detailImage)
            val detail_Producto:TextView? = view?.findViewById(R.id.detailProducto)
            val detail_Precio:TextView? = view?.findViewById(R.id.detailPrecio)

            detail_Nombre?.text = getData.dataNombre
            detail_Image?.setImageResource(getData.dataImage)
            detail_Producto?.text = getData.dataDescrip
            detail_Precio?.text = getData.dataPrecio
        }
    }

}