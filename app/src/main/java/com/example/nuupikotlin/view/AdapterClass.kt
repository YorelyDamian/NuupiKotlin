package com.example.nuupikotlin.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nuupikotlin.R

class AdapterClass(private val dataList:ArrayList<DataClass>):RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.itemImage.setImageResource(currentItem.dataImage)
        holder.itemNombreProduto.text = currentItem.dataNombre
        holder.itemDescripcion.text = currentItem.dataDescrip
        holder.itemPrecio.text = currentItem.dataPrecio
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolderClass (itemView: View):RecyclerView.ViewHolder(itemView){
        val itemImage:ImageView= itemView.findViewById(R.id.item_image)
        val itemNombreProduto:TextView = itemView.findViewById(R.id.item_NombreProduto)
        val itemDescripcion:TextView = itemView.findViewById(R.id.item_descripcion)
        val itemPrecio: TextView = itemView.findViewById(R.id.item_precio)
    }

}