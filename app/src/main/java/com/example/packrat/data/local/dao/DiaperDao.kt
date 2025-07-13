package com.example.packrat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.packrat.data.local.entities.Diaper
import kotlinx.coroutines.flow.Flow

// This DAO has Queries to grab everything in the table and sort it by different parameters.
// It also has add/update and delete functions.
// TODO Add different queries if needed for search.

@Dao
interface DiaperDao {

    // Get all queries
    @Query("SELECT * FROM diaper_table ORDER By id ASC")
    suspend fun getAllDiapersById(): Flow<List<Diaper>>

    @Query("SELECT * FROM diaper_table ORDER by size ASC")
    suspend fun getAllDiapersSortedBySize(): Flow<List<Diaper>>

    @Query("SELECT * FROM diaper_table ORDER by supplier ASC")
    suspend fun getAllDiapersSortedBySupplier(): Flow<List<Diaper>>

    @Query("SELECT * FROM diaper_table ORDER by cost ASC")
    suspend fun getAllDiapersSortedByCost(): Flow<List<Diaper>>

    @Query("SELECT * FROM diaper_table ORDER by associatedProgram ASC")
    suspend fun getAllDiapersSortedByProgram(): Flow<List<Diaper>>

    @Query("SELECT * FROM diaper_table ORDER by assignedTo ASC")
    suspend fun getAllDiapersSortedByAssignedTo(): Flow<List<Diaper>>

    // CRUD Operations
    @Upsert
    suspend fun upsert(diaper: Diaper)

    @Delete
    suspend fun delete(diaper: Diaper)
}