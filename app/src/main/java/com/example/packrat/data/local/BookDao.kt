package com.example.packrat.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)

    @Query("SELECT * FROM books")
    fun getAllBooks(): Flow<List<Book>>

    @Query("SELECT * FROM books WHERE id = :bookId")
    suspend fun getBookById(bookId: Int): Book?

    @Query("SELECT * FROM books WHERE isbn = :isbn")
    suspend fun getBookByIsbn(isbn: String): Book?

    // update book title
    @Query("UPDATE books SET title = :newTitle WHERE id = :bookId")
    suspend fun updateBookTitle(bookId: Int, newTitle: String)

    // update book author
    @Query("UPDATE books SET author = :newAuthor WHERE id = :bookId")
    suspend fun updateBookAuthor(bookId: Int, newAuthor: String)

    // update book unit price
    @Query("UPDATE books SET unitPrice = :newUnitPrice WHERE id = :bookId")
    suspend fun updateBookUnitPrice(bookId: Int, newUnitPrice: Double)

    // update book isbn
    @Query("UPDATE books SET isbn = :newIsbn WHERE id = :bookId")
    suspend fun updateBookIsbn(bookId: Int, newIsbn: String)

    //delete book
    @Delete
    suspend fun deleteBook(book: Book)

    //delete all books
    @Query("DELETE FROM books")
    suspend fun deleteAllBooks()

    //delete book by id
    @Query("DELETE FROM books WHERE id = :bookId")
    suspend fun deleteBookById(bookId: Int)

    //TODO add more queries as needed.
}