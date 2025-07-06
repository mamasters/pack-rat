package com.example.packrat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.packrat.data.local.entities.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    //CRUD

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(book: Book)

    @Update
    suspend fun update(book: Book)

    @Delete
    suspend fun delete(book: Book)

    //Queries

    @Query("SELECT * FROM book_table")
    fun getAllBooks(): Flow<List<Book>>

    @Query("SELECT * FROM book_table WHERE id = :bookId")
    suspend fun getBookById(bookId: Int): Book?

    @Query("SELECT * FROM book_table WHERE isbn = :isbn")
    suspend fun getBookByIsbn(isbn: String): Book?

    //TODO add more queries as needed.
}