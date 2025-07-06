package com.example.packrat.data.local.book

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "books",
    indices = [Index(value = ["title"]), Index(value = ["isbn"], unique = true)],
)
data class Book (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val author: String,
    val isbn: String?,
    val unitPrice: Double?,
)