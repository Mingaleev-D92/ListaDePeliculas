package com.example.listadepeliculas.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.listadepeliculas.data.local.entities.MovieEntity

/**
 * @author : Mingaleev D
 * @data : 31.05.2023
 */

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
   abstract val dao: MovieDao
}