package com.example.nuupikotlin.routes

import com.example.nuupikotlin.models.ResponseHttp
import com.example.nuupikotlin.models.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface UsersRoutes {

    //SE CAMBIO EL CREATE POR ROLES
    @POST("api/users/roles")
    fun register(@Body user:User):Call<ResponseHttp>

    @FormUrlEncoded
    @POST("api/users/login")
    fun login(@Field("email")email:String, @Field("password") password:String):Call<ResponseHttp>

    @Multipart
    @PUT("api/users/update")
    fun update(
        @Part image: MultipartBody.Part,
        @Part("user") user: RequestBody
    ): Call<ResponseHttp>

}