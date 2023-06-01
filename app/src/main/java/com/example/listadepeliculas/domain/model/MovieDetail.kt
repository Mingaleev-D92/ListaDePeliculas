package com.example.listadepeliculas.domain.model

data class MovieDetail(
    val id: Int,
    val image: String,
    val name: String,
    val year: String,
    val language: String,
    val rating: Double,
    val genres: List<String>,
    val description: String
)
