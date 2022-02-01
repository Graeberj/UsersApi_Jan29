package com.example.usersapi_jan29.model.network

import com.example.usersapi_jan29.model.network.models.User
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}