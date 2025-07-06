package com.example.packrat.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.packrat.data.local.interfaces.InventoryItem

@Entity(tableName = "diaper_table")
data class Diaper (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val size: String,
    override val supplier: String,
    override val cost: Double,
    override val itemName: String,
    override val associatedProgram: String,
    override val assignedTo: String? // References Person.idNumber
) : InventoryItem