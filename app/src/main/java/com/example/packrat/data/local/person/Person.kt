package com.example.packrat.data.local.person

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "persons")
data class Person (
    @PrimaryKey(autoGenerate = true) val id: Int = 0

    // TODO Add other attributes and methods
)

