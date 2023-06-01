package com.example.listadepeliculas.ui.home.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listadepeliculas.domain.model.Movie

/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 */

@Composable
fun HomeMovieList(
    modifier: Modifier = Modifier,
    title: String,
    moviePoster: List<Movie>,
    onMovieClicked:(Movie) -> Unit
) {
   Column(modifier = modifier) {
      Text(
          text = title,
          fontWeight = FontWeight.SemiBold,
          fontSize = 20.sp,
          color = Color.White,
      )
      Spacer(modifier = Modifier.height(16.dp))
      LazyRow(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(12.dp)
      ) {
         items(moviePoster) {
            HomePoster(it.poster, MoviePosterSize.SMALL){
               onMovieClicked(it)
            }
         }
      }
   }

}