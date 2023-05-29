package com.example.listadepeliculas.domain.model

data class Movie(
    val description: String,
    val title: String,
    val releaseDate: String,
    val originalLanguage: String,
    val rating: Double,
    val poster: String,
    val genres: List<Int>,
)
