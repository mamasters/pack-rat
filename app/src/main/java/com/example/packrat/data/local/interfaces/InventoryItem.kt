package com.example.packrat.data.local.interfaces

interface InventoryItem {
    val itemName: String
    val associatedProgram: String
    val supplier: String
    val cost: Double
    val assignedTo: String? // Foreign key to Person.idNumber
}