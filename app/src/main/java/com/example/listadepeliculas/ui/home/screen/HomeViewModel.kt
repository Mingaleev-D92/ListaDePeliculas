package com.example.listadepeliculas.ui.home.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadepeliculas.domain.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
   var state by mutableStateOf(HomeState())
      private set

   init {
      state = state.copy(isLoading = true)
      viewModelScope.launch {
         supervisorScope {
            val movies = launch { getAllMovies() }
            movies.join()
            state = state.copy(isLoading = false)
         }
      }
   }

   private suspend fun getAllMovies() {
      repository.getAllMovies(state.selectedFilter, false).collect {
         state = state.copy(
             upcomingMovie = it.upcoming,
             popularMovie = it.popular,
             filteredMovies = it.filtered
         )
      }
   }
   fun onEvent(event: HomeEvent) {
      when (event) {
         is HomeEvent.ChangeFilter -> {
            if (event.filterType != state.selectedFilter) {
               state = state.copy(
                   selectedFilter = event.filterType
               )
               viewModelScope.launch {
                  repository.getAllMovies(state.selectedFilter, true).collect {
                     state = state.copy(
                         filteredMovies = it.filtered
                     )
                  }
               }
            }
         }
         is HomeEvent.OnMovie -> TODO()
      }
   }
}
