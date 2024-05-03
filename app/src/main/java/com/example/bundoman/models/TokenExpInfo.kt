package com.example.bundoman.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TokenExpInfo(
    val nim : String,
    val iat : Long,
    val exp : Long
)
