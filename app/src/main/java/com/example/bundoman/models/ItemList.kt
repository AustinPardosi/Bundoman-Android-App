package com.example.bundoman.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemList(
    val items : Array<Item>,
)
