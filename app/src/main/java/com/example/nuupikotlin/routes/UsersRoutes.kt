package com.example.nuupikotlin.routes

import com.example.nuupikotlin.models.ResponseHttp
import com.example.nuupikotlin.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsersRoutes {

    @POST("CreateUsuario")
    fun register(@Body user:User):Call<ResponseHttp>

    @FormUrlEncoded
    @POST("LoginUsuario")
    fun login(@Field("PemailUsu")email:String, @Field("Pcontra") password:String):Call<ResponseHttp>

}