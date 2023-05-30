package com.example.listadepeliculas.ui.home.screen

import com.example.listadepeliculas.domain.model.Movie

data class HomeState(
    val upcomingMovie: List<Movie> = emptyList(),
    val popularMovie: List<Movie> = emptyList(),
    val isLoading: Boolean = false
)
