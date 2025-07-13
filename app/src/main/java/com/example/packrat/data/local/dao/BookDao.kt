package com.example.packrat.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.packrat.data.local.entities.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    // Get all queries
    @Query("SELECT * FROM book_table ORDER BY id ASC")
    suspend fun getAllBooksById(): Flow<List<Book>>

    @Query("SELECT * FROM book_table ORDER BY title ASC")
    suspend fun getAllBooksByTitle(): List<Book>

    @Query("SELECT * FROM book_table ORDER BY author ASC")
    suspend fun getAllBooksByAuthor(): Flow<List<Book>>

    @Query("SELECT * FROM book_table ORDER BY isbn ASC")
    suspend fun getAllBooksByIsbn(): Flow<List<Book>>

    @Query("SELECT * FROM book_table ORDER BY cost ASC")
    suspend fun getAllBooksByCost(): Flow<List<Book>>

    @Query("SELECT * FROM book_table ORDER BY associatedProgram ASC")
    suspend fun getAllBooksByProgram(): Flow<List<Book>>

    @Query("SELECT * FROM book_table ORDER BY supplier ASC")
    suspend fun getAllBooksBySupplier(): Flow<List<Book>>

    @Query("SELECT * FROM book_table ORDER BY assignedTo ASC")
    suspend fun getAllBooksByAssignedTo(): Flow<List<Book>>

    // Get where queries
    @Query("SELECT * FROM book_table WHERE id = :id")
    suspend fun getBookById(id: Int): Book?

    @Query("SELECT * FROM book_table WHERE isbn = :isbn")
    suspend fun getBookByIsbn(isbn: String): Book?

    @Query("SELECT * FROM book_table WHERE title LIKE '%' || :searchQuery || '%' OR author LIKE '%' || :searchQuery || '%'")
    suspend fun searchBooks(searchQuery: String): Flow<List<Book>>

    @Query("SELECT * FROM book_table WHERE associatedProgram = :program")
    suspend fun getBooksByProgram(program: String): Flow<List<Book>>

    @Query("SELECT * FROM book_table WHERE assignedTo = :personId")
    suspend fun getBooksByAssignedPerson(personId: String): Flow<List<Book>>

    @Query("SELECT * FROM book_table WHERE assignedTo IS NULL")
    suspend fun getUnassignedBooks(): Flow<List<Book>>

    // CRUD Operations
    @Query("DELETE FROM book_table")
    suspend fun deleteAllBooks()

    @Query("UPDATE book_table SET assignedTo = :personId WHERE id = :bookId")
    suspend fun assignBookToPerson(bookId: Int, personId: String?)

    @Upsert
    suspend fun upsertBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)
}