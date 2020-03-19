package com.calyrsoft.examplemvp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IBookDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book:Book)

    @Query("SELECT * FROM book_table")
    fun getList(): List<Book>

    @Query("DELETE FROM book_table")
    suspend fun deleteAll()
}