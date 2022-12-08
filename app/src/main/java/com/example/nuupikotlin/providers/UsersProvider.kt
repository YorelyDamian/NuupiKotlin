package com.example.nuupikotlin.providers

import com.example.nuupikotlin.api.ApiRoutes
import com.example.nuupikotlin.models.ResponseHttp
import com.example.nuupikotlin.models.User
import com.example.nuupikotlin.routes.UsersRoutes
import retrofit2.Call

class UsersProvider {

    private var usersRoutes: UsersRoutes?= null

    init {
        val api = ApiRoutes()
        usersRoutes = api.getUsersRoutes()
    }

    fun register(user: User): Call<ResponseHttp>?{
        return usersRoutes?.register(user)
    }
}