package com.example.bundoman.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "category")
    val category: String = "",

    @ColumnInfo(name = "value")
    var value: Double = 0.0,

    @ColumnInfo(name = "location")
    var location: String = "",

    @ColumnInfo(name = "latitude")
    val latitude: Double = 0.0,

    @ColumnInfo(name = "langitude")
    val langitude: Double = 0.0,

    @ColumnInfo(name = "date")
    val date: Long = System.currentTimeMillis()
)