package com.example.packrat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.packrat.data.local.entities.DevelopmentItem
import kotlinx.coroutines.flow.Flow

@Dao
interface DevelopmentItemDao {

    // Get all queries
    @Query("SELECT * FROM development_item_table ORDER BY id ASC")
    suspend fun getAllDevelopmentItemsById(): Flow<List<DevelopmentItem>>

    @Query("SELECT * FROM development_item_table ORDER BY itemName ASC")
    suspend fun getAllDevelopmentItemsByName(): Flow<List<DevelopmentItem>>

    @Query("SELECT * FROM development_item_table ORDER BY associatedProgram ASC")
    suspend fun getAllDevelopmentItemsByProgram(): Flow<List<DevelopmentItem>>

    @Query("SELECT * FROM development_item_table ORDER BY supplier ASC")
    suspend fun getAllDevelopmentItemsBySupplier(): Flow<List<DevelopmentItem>>

    @Query("SELECT * FROM development_item_table ORDER BY cost ASC")
    suspend fun getAllDevelopmentItemsByCost(): Flow<List<DevelopmentItem>>

    @Query("SELECT * FROM development_item_table ORDER BY assignedTo ASC")
    suspend fun getAllDevelopmentItemsByAssignedPerson(): Flow<List<DevelopmentItem>>

    //Get where queries
    @Query("SELECT * FROM development_item_table WHERE id = :id")
    suspend fun getDevelopmentItemById(id: Int): DevelopmentItem?

    @Query("SELECT * FROM development_item_table WHERE itemName LIKE '%' || :searchQuery || '%'")
    suspend fun searchDevelopmentItems(searchQuery: String): Flow<List<DevelopmentItem>>

    @Query("SELECT * FROM development_item_table WHERE associatedProgram = :program")
    suspend fun getDevelopmentItemsByProgram(program: String): Flow<List<DevelopmentItem>>

    @Query("SELECT * FROM development_item_table WHERE assignedTo = :personId")
    suspend fun getDevelopmentItemsByAssignedPerson(personId: String): Flow<List<DevelopmentItem>>

    @Query("SELECT * FROM development_item_table WHERE assignedTo IS NULL")
    suspend fun getUnassignedDevelopmentItems(): Flow<List<DevelopmentItem>>

    // CRUD Operations
    @Query("DELETE FROM development_item_table")
    suspend fun deleteAllDevelopmentItems()

    @Query("UPDATE development_item_table SET assignedTo = :personId WHERE id = :itemId")
    suspend fun assignDevelopmentItemToPerson(itemId: Int, personId: String?)

    @Upsert
    suspend fun upsertDevelopmentItem(item: DevelopmentItem)

    @Delete
    suspend fun deleteDevelopmentItem(item: DevelopmentItem)
}