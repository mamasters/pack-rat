package com.example.packrat.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person (
    @PrimaryKey(autoGenerate = true) val idNumber: Int = 0,
)