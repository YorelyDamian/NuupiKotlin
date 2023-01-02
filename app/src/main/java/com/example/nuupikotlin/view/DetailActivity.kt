package com.example.nuupikotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.nuupikotlin.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val getData = intent.getParcelableExtra<DataClass>("android")
        if (getData != null){
            val detail_Nombre:TextView= findViewById(R.id.detailNombre)
            val detail_Image:ImageView= findViewById(R.id.detailImage)
            val detail_Producto:TextView= findViewById(R.id.detailProducto)
            val detail_Precio:TextView= findViewById(R.id.detailPrecio)

            detail_Nombre.text = getData.dataNombre
            detail_Image.setImageResource(getData.dataImage)
            detail_Producto.text = getData.dataDescrip
            detail_Precio.text = getData.dataPrecio
        }
    }
}