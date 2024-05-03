package com.example.bundoman.models
import java.util.Date

data class Transaction (
    val id: Int,
    val title: String,
    val category: String,
    val value: Double,
    val location: String,
    val latitude: Double,
    val longitude: Double,
    val date: Date
)

