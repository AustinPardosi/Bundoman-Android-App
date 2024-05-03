package com.example.bundoman.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User (
    val email: String,
    val password: String
)