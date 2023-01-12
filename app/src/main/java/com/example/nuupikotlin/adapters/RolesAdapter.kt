package com.example.nuupikotlin.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nuupikotlin.MainActivity
import com.example.nuupikotlin.R
import com.example.nuupikotlin.administrador.AdminActivity
import com.example.nuupikotlin.models.Rol
import com.example.nuupikotlin.utils.SharedPref

class RolesAdapter (val context: Activity, val roles:ArrayList<Rol>):RecyclerView.Adapter<RolesAdapter.RolesViewHolder>(){

    val sharedPref = SharedPref(context)

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int): RolesViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_roles,parent,false)
        return RolesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return roles.size
    }

    override fun onBindViewHolder(holder: RolesViewHolder,position:Int){
        val rol = roles[position]//cada rol
        holder.textViewRol.text = rol.DescripRol

        holder.itemView.setOnClickListener{ gotoRol(rol) }

    }

    private fun gotoRol(rol:Rol){
        if(rol.DescripRol == "ADMIN"){
            sharedPref.save("rol", "ADMIN")
            val i = Intent(context,AdminActivity::class.java)
            context.startActivity(i)
        }
        else if(rol.DescripRol == "CLIENTE"){
            sharedPref.save("rol", "CLIENTE")
            val i = Intent(context,MainActivity::class.java)
            context.startActivity(i)
        }
    }

    class RolesViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textViewRol: TextView
        init {
            textViewRol = view.findViewById(R.id.txt_rol)
        }
    }

}