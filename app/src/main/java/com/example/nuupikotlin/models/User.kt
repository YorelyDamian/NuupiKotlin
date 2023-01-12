package com.example.nuupikotlin.models

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class User (
    @SerializedName("idUsuario") val idUsuario:String? = null,
    @SerializedName("psnombreUsuario") val psnombreUsuario: String? = null,
    @SerializedName("psapellido1Usuario") val psapellido1Usuario: String? = null,
    @SerializedName("psapellido2Usuario") val psapellido2Usuario: String? = null,
    @SerializedName("pstelefonoUsuario") val pstelefonoUsuario: String? = null,
    @SerializedName("psPemailUsu") val psPemailUsu: String? = null,
    @SerializedName("pscontraUsuario") val pscontraUsuario: String? = null,
    @SerializedName("psconfirmaContraUsuario") val psconfirmaContraUsuario: String? = null,
    @SerializedName("psfechaNacimiento") val psfechaNacimiento: String? = null,
    @SerializedName("fechaRegistroUsuario") val fechaRegistroUsuario:String? = null,
    @SerializedName("status") val status:String? = null,
    @SerializedName("rfcUsuario") val rfcUsuario:String? = null,
    @SerializedName("codeActive") val codeActive:String? = null,
    @SerializedName("clienidpaypal") val clienidpaypal:String? = null,
    @SerializedName("pk_mercadopago") val pk_mercadopago:String? = null,
    @SerializedName("accessTokenMpago") val accessTokenMpago:String? = null,
    @SerializedName("roles") val roles: ArrayList<Rol>?= null


){
    override fun toString(): String {
        return "User(idUsuario='$idUsuario',psnombreUsuario='$psnombreUsuario', psapellido1Usuario='$psapellido1Usuario', psapellido2Usuario='$psapellido2Usuario', pstelefonoUsuario='$pstelefonoUsuario', psPemailUsu='$psPemailUsu', pscontraUsuario='$pscontraUsuario', psconfirmaContraUsuario='$psconfirmaContraUsuario', psfechaNacimiento='$psfechaNacimiento', fechaRegistroUsuario='$fechaRegistroUsuario', status='$status', rfcUsuario='$rfcUsuario', codeActive='$codeActive', clienidpaypal='$clienidpaypal', pk_mercadopago='$pk_mercadopago', accessTokenMpago='$accessTokenMpago', roles='$roles')"
    }

    fun toJson(): String{
        return Gson().toJson(this)
    }

}