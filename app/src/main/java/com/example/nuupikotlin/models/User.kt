package com.example.nuupikotlin.models

import com.google.gson.annotations.SerializedName

class User (
    @SerializedName("idUsuario") val idUsuario: String,
    @SerializedName("nombreUsuario") val nombreUsuario: String,
    @SerializedName("apellido1Usuario") val apellido1Usuario: String,
    @SerializedName("apellido2Usuario") val apellido2Usuario: String,
    @SerializedName("telefonoUsuario") val telefonoUsuario: Int,
    @SerializedName("emailUsuario") val emailUsuario: String,
    @SerializedName("contraUsuario") val contraUsuario: String,
    @SerializedName("confirmarContraUsuario") val confirmarContraUsuario: String,
    @SerializedName("fechaNacimiento") val fechaNacimiento: String,
        ){

    override fun toString(): String {
        return "User(idUsuario='$idUsuario', nombreUsuario='$nombreUsuario', apellido1Usuario='$apellido1Usuario', apellido2Usuario='$apellido2Usuario', telefonoUsuario=$telefonoUsuario, emailUsuario='$emailUsuario', contraUsuario='$contraUsuario', confirmarContraUsuario='$confirmarContraUsuario', fechaNacimiento='$fechaNacimiento')"
    }
}