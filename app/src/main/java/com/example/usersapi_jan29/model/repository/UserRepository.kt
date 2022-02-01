package com.example.usersapi_jan29.model.repository

import com.example.usersapi_jan29.model.network.ApiManager
import com.example.usersapi_jan29.model.network.models.User
import java.lang.Exception

class UserRepository(
    private val apiManager: ApiManager
) {
    suspend fun getUsers(): List<User>? {
        return try {
            val response = apiManager.getUsers()
            if (response.isSuccessful) {
                response.body()
            } else {
                emptyList()
            }
        } catch (ex: Exception) {
            emptyList()
        }
    }
}