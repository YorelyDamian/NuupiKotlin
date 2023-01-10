package com.example.nuupikotlin.api

import com.example.nuupikotlin.routes.UsersRoutes

class ApiRoutes {

    val API_URL="http://192.168.0.10:3000/"
    val retrofit = RetrofitClient()
    fun getUsersRoutes(): UsersRoutes {
        return retrofit.getClient(API_URL).create(UsersRoutes::class.java)

    }

}