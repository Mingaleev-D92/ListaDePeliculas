package com.example.listadepeliculas.ui.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.listadepeliculas.R
import com.example.listadepeliculas.ui.home.screen.components.HomeHeader
import com.example.listadepeliculas.ui.home.screen.components.HomeMovieList

/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 */

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
   val state = viewModel.state
   LazyColumn(
       modifier = Modifier
           .fillMaxSize()
           .padding(start = 20.dp)
   ) {
      item {
         HomeHeader()
      }
      if (state.upcomingMovie.isNotEmpty()) {
         item() {
            HomeMovieList(
                title = stringResource(id = R.string.to_be_movie),
                moviePoster = state.upcomingMovie.map { it.poster }
            )
         }
      }
      item { Spacer(modifier = Modifier.height(16.dp)) }
      if (state.popularMovie.isNotEmpty()) {
         item() {
            HomeMovieList(
                title = stringResource(id = R.string.popular_movie),
                moviePoster = state.popularMovie.map { it.poster }
            )
         }
      }
   }
   if (state.isLoading) {
      Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
         CircularProgressIndicator()
      }
   }
}