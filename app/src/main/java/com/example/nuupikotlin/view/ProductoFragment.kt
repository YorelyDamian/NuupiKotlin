package com.example.nuupikotlin.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nuupikotlin.R

class ProductoFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var nombreList:Array<String>
    lateinit var drecripList:Array<String>
    lateinit var precioList:Array<String>
    private lateinit var myAdapter: AdapterClass

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_producto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageList = arrayOf(
            R.drawable.amor,
            R.drawable.paleta,
            R.drawable.fresas,
            R.drawable.madrecita,
            R.drawable.carita,
            R.drawable.muertos,
            R.drawable.gatito,
            R.drawable.navidad1,
            R.drawable.navidad2,
            R.drawable.navidad3,
            R.drawable.navidad4,
            R.drawable.frutales)

        nombreList = arrayOf("AMOR",
            "PALETA",
            "FRESAS",
            "DÍA DE LAS MADRES",
            "SONREIR",
            "DÍA DE MUERTOS",
            "CAT AND CAT",
            "ARBOLITO DE NAVIDAD",
            "REGALITOS",
            "PALETAS DE GRANEL",
            "FELIZ NAVIDAD",
            "FRUTS AND FRUTS")

        drecripList = arrayOf("Caramelo con sabores frutales",
            "Paleta con sabores frutales",
            "Caramelo con sabores frutales",
            "Paleta con sabores frutales de temporada",
            "Caramelo con sabores frutales",
            "Paleta con sabores frutales de temporada",
            "Caramelo con sabores frutales",
            "Caramelo con sabores frutales de temporada",
            "Caramelo con sabores frutales de temporada",
            "Paleta con sabores frutales de temporada",
            "Paleta con sabores frutales de temporadas",
            "Caramelo con sabores frutales")

        precioList = arrayOf("$36mx por frasco (75 gramos)",
            "$25mx por paleta",
            "$36mx por frasco (75 gramos)",
            "$25mx por paleta",
            "$36mx por frasco (75 gramos)",
            "$25mx por paleta",
            "$36mx por frasco (75 gramos)",
            "$36mx por frasco (75 gramos)",
            "$36mx por frasco (75 gramos)",
            "$25mx por paleta de arbol y bastones a $12mx",
            "$25mx por paleta",
            "$36mx por frasco (75 gramos)")

        recyclerView= view.findViewById(R.id.rvProductos)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf<DataClass>()
        getData()

        myAdapter = AdapterClass(dataList)
        recyclerView.adapter = myAdapter

        myAdapter.onItemClick={
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("android",it)
            startActivity(intent)
        }

    }

    private fun getData(){
        for(i in imageList.indices){
            val dataClass = DataClass(nombreList[i],imageList[i],drecripList[i],precioList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClass(dataList)
    }

}