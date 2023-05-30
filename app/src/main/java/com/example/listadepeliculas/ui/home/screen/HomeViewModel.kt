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
    val repository: MovieRepository
) : ViewModel() {
   var state by mutableStateOf(HomeState())
      private set

   init {
      state = state.copy(isLoading = true)
      viewModelScope.launch {
         supervisorScope {
            val upcoming = launch { getUpcomingMovie() }
            val popular = launch { getPopularMovie() }
            listOf(upcoming,popular).forEach { it.join() }
            state = state.copy(isLoading = false)
         }
      }
   }

   private suspend fun getUpcomingMovie() {
      repository.getUpcomingMovie()
          .onSuccess {
             state = state.copy(upcomingMovie = it)
          }
          .onFailure {
             println()
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
}