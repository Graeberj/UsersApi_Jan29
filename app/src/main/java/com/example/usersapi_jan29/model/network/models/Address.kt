package com.example.usersapi_jan29.model.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo,
)
