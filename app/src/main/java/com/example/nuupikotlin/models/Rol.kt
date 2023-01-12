package com.example.nuupikotlin.models

import com.google.gson.annotations.SerializedName

class Rol(
    @SerializedName("idRole")val idRole:String? = null,
    @SerializedName("DescripRol")val DescripRol:String? = null
){
    override fun toString(): String {
        return "Rol(idRole=$idRole, DescripRol=$DescripRol)"
    }


}