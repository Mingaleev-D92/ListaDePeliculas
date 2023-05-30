package com.example.listadepeliculas.ui.home.screen

import com.example.listadepeliculas.domain.model.Movie

data class HomeState(
    val upcoming: List<Movie> = emptyList(),
    val isLoading: Boolean = false
)
