package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.periferia.metas_amway.persistence.entities.Book

@Dao
interface BookDao {

    @Insert
    fun saveBook(book:Book)

    @Query("SELECT * FROM book")
    fun bookList() : List<Book>

    @Query("UPDATE book SET current_page = :page WHERE id= :id")
    fun setCurrentPage(page:Int, id:Int)


}