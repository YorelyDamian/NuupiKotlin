package com.example.nuupikotlin.models

import com.google.gson.annotations.SerializedName

class ResponseHttp(
    @SerializedName("message") val message: String
) {
    override fun toString(): String {
        return "ResponseHttp(message='$message')"
    }
}