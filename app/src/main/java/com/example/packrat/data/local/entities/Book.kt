package com.example.packrat.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.packrat.data.local.interfaces.InventoryItem

// TODO Add indices to improve performance of queries
@Entity(tableName = "book_table")
data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val author: String,
    val isbn: String?,
    override val cost: Double,
    override val associatedProgram: String,
    override val supplier: String,
    override val assignedTo: String? // References Person.idNumber
) : InventoryItem {
    override val itemName: String get() = title
}