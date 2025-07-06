package com.example.packrat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.packrat.data.local.entities.MarketingItem

@Dao
interface MarketingItemDao {

    // CRUD
    @Insert
    fun insert(item: MarketingItem)

    @Update
    fun update(item: MarketingItem)

    @Delete
    fun delete(item: MarketingItem)

    // TODO Add Queries
}