package com.example.listadepeliculas.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_entity")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val poster: String,
    val type: MovieType
)

enum class MovieType {
    UPCOMING,
    TRENDING_POPULAR,
    ENGLISH_LANG,
    SPAIN_LANG
}
