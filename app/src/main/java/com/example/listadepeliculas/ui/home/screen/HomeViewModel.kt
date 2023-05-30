package com.example.listadepeliculas.ui.home.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadepeliculas.domain.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
      getUpcomingMovie()

   }

   private fun getUpcomingMovie() {
      viewModelScope.launch {
         repository.getUpcomingMovie()
             .onSuccess {
                state = state.copy(upcoming = it)
             }
             .onFailure {
                println()
             }
         state = state.copy(isLoading = false)
      }

   }
}