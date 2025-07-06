package com.example.packrat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.packrat.data.local.entities.Person

@Dao
interface PersonDao {

    // CRUD
    @Insert
    fun insert(person: Person)

    @Update
    fun update(person: Person)

    @Delete
    fun delete(person: Person)

    // Queries
    @Query("SELECT * FROM person_table")
    fun getAll(): List<Person>

    @Query("SELECT * FROM person_table WHERE idNumber = :id")
    fun getById(id: Int): Person
}