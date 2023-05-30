package com.example.listadepeliculas.ui.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 */

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
   val state = viewModel.state
   LazyColumn(modifier = Modifier.fillMaxSize()) {
      if (state.upcoming.isNotEmpty()) {
         item() {
            Text(text = "Следующие премьеры")
            LazyRow(modifier = Modifier.fillMaxWidth()) {
               items(state.upcoming) {
                  Text(text = it.title)
               }
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