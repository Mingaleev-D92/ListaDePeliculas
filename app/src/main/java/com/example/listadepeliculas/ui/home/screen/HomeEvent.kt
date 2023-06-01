package com.example.listadepeliculas.ui.home.screen

import com.example.listadepeliculas.domain.model.FilterType

sealed class HomeEvent {
   data class ChangeFilter(val filterType: FilterType) : HomeEvent()
   data class OnMovie(val movieId: Int) : HomeEvent()
}
