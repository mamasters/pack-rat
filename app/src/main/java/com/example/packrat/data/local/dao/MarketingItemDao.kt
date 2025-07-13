package com.example.packrat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.packrat.data.local.entities.MarketingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface MarketingItemDao {

    // Get all queries
    @Query("SELECT * FROM marketing_item_table ORDER BY id ASC")
    suspend fun getAllMarketingItemsByID(): Flow<List<MarketingItem>>

    @Query("SELECT * FROM marketing_item_table ORDER BY itemName ASC")
    suspend fun getAllMarketingItemsByName(): Flow<List<MarketingItem>>

    @Query("SELECT * FROM marketing_item_table ORDER BY associatedProgram ASC")
    suspend fun getAllMarketingItemsByProgram(): Flow<List<MarketingItem>>

    @Query("SELECT * FROM marketing_item_table ORDER BY supplier ASC")
    suspend fun getAllMarketingItemsBySupplier(): Flow<List<MarketingItem>>

    @Query("SELECT * FROM marketing_item_table ORDER BY cost ASC")
    suspend fun getAllMarketingItemsByCost(): Flow<List<MarketingItem>>

    @Query("SELECT * FROM marketing_item_table ORDER BY assignedTo ASC")
    suspend fun getAllMarketingItemsByAssignedTo(): Flow<List<MarketingItem>>

    // CRUD
    @Upsert
    suspend fun upsert(item: MarketingItem)

    @Delete
    suspend fun delete(item: MarketingItem)
}