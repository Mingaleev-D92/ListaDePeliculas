package com.example.listadepeliculas.ui.home.screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.listadepeliculas.R
import com.example.listadepeliculas.domain.model.Movie

/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 */

@Composable
fun HomeRecommended(
    selectedFilter: FilterType,
    onFilterClick: (FilterType) -> Unit,
    moveList: List<Movie>,
    modifier: Modifier = Modifier,
    onMovieClick: (Movie) -> Unit,
) {
   LazyColumn(modifier = modifier.fillMaxWidth()) {
      item {
         CategoryTitle(title = stringResource(id = R.string.recommended_movie))
      }
      item {
         FilterPillContainer(
             filters = FilterType.values().toList(),
             selectedFilter = selectedFilter,
             onFilterClick = onFilterClick
         )
      }
   }
}