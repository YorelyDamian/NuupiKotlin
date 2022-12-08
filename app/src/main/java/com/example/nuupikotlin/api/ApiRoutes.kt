package com.example.nuupikotlin.api

import com.example.nuupikotlin.routes.UsersRoutes

class ApiRoutes {

    val API_URL="http://apirestnuupi-production.up.railway.app/api/Nuupi/"
    val retrofit = RetrofitClient()
    fun getUsersRoutes(): UsersRoutes {
        return retrofit.getClient(API_URL).create(UsersRoutes::class.java)
    }

}