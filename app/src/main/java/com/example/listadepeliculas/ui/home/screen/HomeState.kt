package com.example.listadepeliculas.ui.home.screen

import com.example.listadepeliculas.domain.model.Movie
import com.example.listadepeliculas.ui.home.screen.components.FilterType

data class HomeState(
    val upcomingMovie: List<Movie> = emptyList(),
    val popularMovie: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val selectedFilter: FilterType = FilterType.ENGLISH,
    val filteredMovies:List<Movie> = emptyList(),
)
