package com.example.nuupikotlin.routes

import com.example.nuupikotlin.models.ResponseHttp
import com.example.nuupikotlin.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsersRoutes {
    //SE CAMBIO EL CREATE POR ROLES
    @POST("api/users/roles")
    fun register(@Body user:User):Call<ResponseHttp>

    @FormUrlEncoded
    @POST("api/users/login")
    fun login(@Field("email")email:String, @Field("password") password:String):Call<ResponseHttp>

}