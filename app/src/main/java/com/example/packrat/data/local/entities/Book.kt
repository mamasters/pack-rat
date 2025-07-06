package com.example.packrat.data.local.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.packrat.data.local.interfaces.InventoryItem

@Entity(
    tableName = "book_table",
    indices = [Index(value = ["title"]), Index(value = ["isbn"], unique = true)]
)
data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val author: String,
    val isbn: String?,
    val unitPrice: Double?,
    override val associatedProgram: String,
    override val supplier: String,
    override val assignedTo: String? // References Person.idNumber
) : InventoryItem {
    override val itemName: String get() = title
    override val cost: Double get() = unitPrice ?: 0.0
}