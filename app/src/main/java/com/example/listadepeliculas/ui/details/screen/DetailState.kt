package com.example.listadepeliculas.ui.details.screen

import com.example.listadepeliculas.domain.model.MovieDetail

data class DetailState(
    val movie: MovieDetail? = null,
    val isLoading: Boolean = false
)
