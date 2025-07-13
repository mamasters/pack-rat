package com.example.packrat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.packrat.data.local.entities.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    // Get all queries
    @Query("SELECT * FROM person_table ORDER BY idNumber ASC")
    fun getAllPersons(): Flow<List<Person>>

    //Get where queries
    @Query("SELECT * FROM person_table WHERE idNumber = :idNumber")
    suspend fun getPersonById(idNumber: String): Person?

    @Query("SELECT * FROM person_table WHERE idNumber LIKE '%' || :searchQuery || '%'")
    fun searchPersons(searchQuery: String): Flow<List<Person>>

    // Useful queries for checking assignments
    @Query("SELECT EXISTS(SELECT 1 FROM book_table WHERE assignedTo = :personId UNION SELECT 1 FROM development_item_table WHERE assignedTo = :personId)")
    suspend fun personHasAssignedItems(personId: String): Boolean

    //CRUD Operations
    @Upsert
    suspend fun upsertPerson(person: Person)

    @Delete
    suspend fun deletePerson(person: Person)

    @Query("DELETE FROM person_table")
    suspend fun deleteAllPersons()
}