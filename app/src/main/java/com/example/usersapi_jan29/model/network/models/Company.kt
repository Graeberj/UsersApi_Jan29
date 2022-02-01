package com.example.usersapi_jan29.model.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String,

)
