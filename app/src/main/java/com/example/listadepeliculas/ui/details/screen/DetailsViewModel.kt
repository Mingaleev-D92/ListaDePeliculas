package com.example.listadepeliculas.ui.details.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadepeliculas.domain.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 01.06.2023
 */

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: MovieRepository
) : ViewModel() {

   var statedgs by mutableStateOf(DetailState())
      private set

   init {
      statedgs = statedgs.copy(
       isLoading = true
      )
      val movieId = savedStateHandle.get<Int>("movie_id")
      movieId?.let {
         viewModelScope.launch {
            repository.getMovieById(movieId).onSuccess {
               statedgs = statedgs.copy(
                   movie = it
               )
            }.onFailure {
               println()
            }
            statedgs = statedgs.copy(
                isLoading = false
            )
         }
      }
   }
}
