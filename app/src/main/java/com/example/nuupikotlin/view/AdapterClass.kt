package com.example.nuupikotlin.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.nuupikotlin.R

class AdapterClass(private val dataList:ArrayList<DataClass>):RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolderClass(itemView)

        //val btnCarrito: Button = itemView.findViewById(R.id.btnCarrito)
        //val btnCompra:Button = itemView.findViewById(R.id.btnCompra)

        //btnCarrito.setOnClickListener {
            //findViewNavController(R.layout.fragment_carrito)
        //}
        //btnCompra.setOnClickListener {
            //findNavController(itemView).navigate(R.id.action_nav_Producto_to_nav_Pago)
        //}

    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.itemNombreProduto.text = currentItem.dataNombre
        holder.itemImage.setImageResource(currentItem.dataImage)
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