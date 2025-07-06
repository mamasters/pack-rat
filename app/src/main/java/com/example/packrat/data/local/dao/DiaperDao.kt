package com.example.packrat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.packrat.data.local.entities.Diaper

@Dao
interface DiaperDao {

    // CRUD
    @Insert
    fun insert(diaper: Diaper)

    @Update
    fun update(diaper: Diaper)

    @Delete
    fun delete(diaper: Diaper)

    //Queries
    @Query("SELECT * FROM diaper_table")
    fun getAll(): List<Diaper>

    //TODO add more queries
}