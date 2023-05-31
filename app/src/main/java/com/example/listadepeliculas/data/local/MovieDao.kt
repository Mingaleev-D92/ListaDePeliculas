package com.example.listadepeliculas.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.listadepeliculas.data.local.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author : Mingaleev D
 * @data : 31.05.2023
 */

@Dao
interface MovieDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertMovie(movieEntity: MovieEntity)

   @Query("SELECT * FROM movie_entity")
   suspend fun getMovies(): List<MovieEntity>
}