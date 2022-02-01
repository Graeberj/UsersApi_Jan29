package com.example.usersapi_jan29.model.network.models

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company,

)