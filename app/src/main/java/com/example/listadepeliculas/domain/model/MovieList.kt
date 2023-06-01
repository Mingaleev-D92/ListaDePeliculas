package com.example.listadepeliculas.domain.model

data class MovieList(
    val upcoming:List<Movie>,
    val popular:List<Movie>,
    val filtered:List<Movie>
)
