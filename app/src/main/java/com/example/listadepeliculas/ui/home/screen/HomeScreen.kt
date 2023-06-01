package com.example.listadepeliculas.ui.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.listadepeliculas.R
import com.example.listadepeliculas.data.common.Constants.COUNT_IN_GRID
import com.example.listadepeliculas.domain.model.Movie
import com.example.listadepeliculas.ui.home.screen.components.HomeHeader
import com.example.listadepeliculas.ui.home.screen.components.HomeMovieList
import com.example.listadepeliculas.ui.home.screen.components.HomePoster
import com.example.listadepeliculas.ui.home.screen.components.HomeRecommended
import com.example.listadepeliculas.ui.home.screen.components.MoviePosterSize

/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 */

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onMovieClick:(Movie) -> Unit
) {
   val state = viewModel.state

   LazyVerticalGrid(
       columns = GridCells.Fixed(COUNT_IN_GRID),
       modifier = Modifier
           .fillMaxSize()
           .padding(start = 16.dp),
       horizontalArrangement = Arrangement.spacedBy(14.dp),
       verticalArrangement = Arrangement.spacedBy(14.dp)
   ) {
      item(span = {
         GridItemSpan(COUNT_IN_GRID)
      }) {
         HomeHeader()
      }

      if (state.upcomingMovie.isNotEmpty()) {
         item(span = {
            GridItemSpan(COUNT_IN_GRID)
         }) {
            HomeMovieList(
                title = stringResource(id = R.string.to_be_movie),
                moviePoster = state.upcomingMovie
            ){
               onMovieClick(it)
            }
         }
      }

      if (state.popularMovie.isNotEmpty()) {
         item(span = {
            GridItemSpan(COUNT_IN_GRID)
         }) {
            HomeMovieList(
                title = stringResource(id = R.string.popular_movie),
                moviePoster = state.popularMovie
            ){
               onMovieClick(it)
            }
         }
      }

      if (state.filteredMovies.isNotEmpty()) {
         item(span = {
            GridItemSpan(COUNT_IN_GRID)
         }) {
            HomeRecommended(
                selectedFilter = state.selectedFilter,
                onFilterClick = {
                   viewModel.onEvent(HomeEvent.ChangeFilter(it))
                }
            )
         }

         items(state.filteredMovies) {
            HomePoster(imageUrl = it.poster, posterSize = MoviePosterSize.BIG){
               onMovieClick(it)
            }
         }
      }
   }
   
   if (state.isLoading) {
      Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
         CircularProgressIndicator()
      }
   }
}