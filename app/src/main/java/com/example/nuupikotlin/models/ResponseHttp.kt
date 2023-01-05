package com.example.nuupikotlin.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

class ResponseHttp(
    @SerializedName("message") val message: String,
    @SerializedName("success") val inSuccess: Boolean,
    @SerializedName("data") val data: JsonObject,
    @SerializedName("error") val error: String
) {
    override fun toString(): String {
        return "ResponseHttp(message='$message', inSuccess=$inSuccess, data=$data, error='$error')"
    }
}