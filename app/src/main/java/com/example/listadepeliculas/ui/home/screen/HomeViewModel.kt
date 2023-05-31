package com.example.listadepeliculas.ui.home.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadepeliculas.domain.MovieRepository
import com.example.listadepeliculas.ui.home.screen.components.FilterType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
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
            val upcoming = launch { getUpcomingMovie() }
            val popular = launch { getPopularMovie() }
            val filtered = launch { getMovieFilter() }
            listOf(upcoming, popular, filtered).forEach { it.join() }
            state = state.copy(isLoading = false)
         }
      }
   }

   private suspend fun getUpcomingMovie() {
      repository.getUpcomingMovie().collect{
         state = state.copy(
             upcomingMovie = it
         )
      }
   }

   private suspend fun getPopularMovie() {
      repository.getPopularMovie()
          .onSuccess {
             state = state.copy(popularMovie = it)
          }
          .onFailure {
             println()
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
                  getMovieFilter()
               }
            }
         }

         is HomeEvent.OnMovie -> TODO()
      }
   }

   private suspend fun getMovieFilter() {
      val jobResult = when (state.selectedFilter) {
         FilterType.ENGLISH -> repository.getMovieEngFilter("en")
         FilterType.RELEASED -> repository.getMovieEsFilter("es")
      }
      jobResult.onSuccess {
         state = state.copy(
             filteredMovies = it
         )
      }.onFailure {

      }
   }
}