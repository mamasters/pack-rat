package com.example.packrat.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.packrat.data.local.interfaces.InventoryItem

@Entity(tableName = "marketing_item_table")
data class MarketingItem (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    override val itemName: String,
    override val associatedProgram: String,
    override val supplier: String,
    override val cost: Double,
    override val assignedTo: String? // References Person.idNumber
) : InventoryItem