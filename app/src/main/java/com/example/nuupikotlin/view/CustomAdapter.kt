package com.example.nuupikotlin.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nuupikotlin.R

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val images = intArrayOf(R.drawable.amor,
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

    val nombre = arrayOf("AMOR",
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

    val details = arrayOf("Caramelo con sabores frutales",
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

    val precio = arrayOf("$36mx por frasco (75 gramos)",
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

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])
        viewHolder.itemNombreProduto.text = nombre[i]
        viewHolder.itemDescripcion.text = details[i]
        viewHolder.itemPrecio.text = precio[i]
    }

    override fun getItemCount(): Int {
        return nombre.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemNombreProduto: TextView
        var itemDescripcion: TextView
        var itemPrecio: TextView

        init {
            itemImage= itemView.findViewById(R.id.item_image)
            itemNombreProduto= itemView.findViewById(R.id.item_NombreProduto)
            itemDescripcion= itemView.findViewById(R.id.item_descripcion)
            itemPrecio= itemView.findViewById(R.id.item_precio)

        }
    }
}