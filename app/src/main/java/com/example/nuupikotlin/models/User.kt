package com.example.nuupikotlin.models

import com.google.gson.annotations.SerializedName

class User (
    @SerializedName("psnombreUsuario") val psnombreUsuario: String,
    @SerializedName("psapellido1Usuario") val psapellido1Usuario: String,
    @SerializedName("psapellido2Usuario") val psapellido2Usuario: String,
    @SerializedName("pstelefonoUsuario") val pstelefonoUsuario: String,
    @SerializedName("psPemailUsu") val psPemailUsu: String,
    @SerializedName("pscontraUsuario") val pscontraUsuario: String,
    @SerializedName("psconfirmaContraUsuario") val psconfirmaContraUsuario: String,
    @SerializedName("psfechaNacimiento") val psfechaNacimiento: String,
        ){

    override fun toString(): String {
        return "User(nombreUsuario='$psnombreUsuario', apellido1Usuario='$psapellido1Usuario', apellido2Usuario='$psapellido2Usuario', telefonoUsuario=$pstelefonoUsuario, emailUsuario='$psPemailUsu', contraUsuario='$pscontraUsuario', confirmarContraUsuario='$psconfirmaContraUsuario', fechaNacimiento='$psfechaNacimiento')"
    }
}