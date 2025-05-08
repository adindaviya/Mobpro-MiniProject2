package com.adindaviya0052.miniproject2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.adindaviya0052.miniproject2.model.Film
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    @Insert
    suspend fun insert(film: Film)

    @Update
    suspend fun update(film: Film)

    @Query("SELECT * FROM film WHERE isDeleted = 0 ORDER BY judul ASC")
    fun getFilm(): Flow<List<Film>>

    @Query("SELECT * FROM film WHERE id = :id")
    suspend fun getFilmById(id:Long): Film?

    @Query("DELETE FROM film WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("UPDATE film SET isDeleted = 1 WHERE id = :id")
    suspend fun softDeleteById(id: Long)

    @Query("UPDATE film SET isDeleted = 0 WHERE id = :id")
    suspend fun undoDeleteById(id: Long)

    @Query("SELECT * FROM film WHERE isDeleted = 1 ORDER BY judul ASC")
    fun getDeletedBook(): Flow<List<Film>>
}