package com.example.bundoman.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    val name : String,
    val qty : Int,
    val price : Double,
)
