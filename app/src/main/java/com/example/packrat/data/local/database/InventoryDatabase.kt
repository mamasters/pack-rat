package com.example.packrat.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.packrat.data.local.dao.BookDao
import com.example.packrat.data.local.dao.DevelopmentItemDao
import com.example.packrat.data.local.dao.DiaperDao
import com.example.packrat.data.local.dao.MarketingItemDao
import com.example.packrat.data.local.dao.PersonDao
import com.example.packrat.data.local.entities.Book
import com.example.packrat.data.local.entities.DevelopmentItem
import com.example.packrat.data.local.entities.Diaper
import com.example.packrat.data.local.entities.MarketingItem
import com.example.packrat.data.local.entities.Person

@Database(
    entities = [
        Book::class,
        Diaper::class,
        DevelopmentItem::class,
        MarketingItem::class,
        Person::class
    ],
    version = 1,
    exportSchema = true
)

@TypeConverters(Converters::class)
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao
    abstract fun diaperDao(): DiaperDao
    abstract fun developmentItemDao(): DevelopmentItemDao
    abstract fun marketingItemDao(): MarketingItemDao
    abstract fun personDao(): PersonDao

    companion object {
        @Volatile
        private var INSTANCE: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InventoryDatabase::class.java,
                    "inventory_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}