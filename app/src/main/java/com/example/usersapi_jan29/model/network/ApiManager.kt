package com.example.usersapi_jan29.model.network

import com.example.usersgetapi.model.network.RetrofitInstance


class ApiManager {

    private var userService: UserService =
        RetrofitInstance.providesRetrofit().create(UserService::class.java)

    suspend fun getUsers() = userService.getUsers()

}