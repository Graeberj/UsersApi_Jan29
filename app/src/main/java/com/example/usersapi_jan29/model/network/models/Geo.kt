package com.example.usersapi_jan29.model.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Geo(
    val lat: String,
    val lng: String
    )
