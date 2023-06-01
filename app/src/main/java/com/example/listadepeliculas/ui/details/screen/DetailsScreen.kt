package com.example.listadepeliculas.ui.details.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.listadepeliculas.data.common.Constants.POSTER_POINT
import com.example.listadepeliculas.ui.details.screen.components.DetailMovieInformation

/**
 * @author : Mingaleev D
 * @data : 01.06.2023
 */

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
   val state = viewModel.statedgs
   Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      if (state.movie != null) {
         AsyncImage(
             model = ImageRequest.Builder(LocalContext.current)
                 .data(state.movie.image)
                 .crossfade(true)
                 .build(),
             contentDescription = "background",
             modifier = Modifier.fillMaxSize(),
             contentScale = ContentScale.FillBounds
         )
         Box(
             modifier = Modifier
                 .fillMaxSize()
                 .background(
                     Brush.verticalGradient(
                         colors = listOf(
                             Color.Black,
                             Color.Black.copy(alpha = 0.2f),
                             Color.Black.copy(alpha = 0.6f),
                             Color.Black.copy(alpha = 0.9f)
                         )
                     )
                 )
         )
         var offsetY by remember { mutableStateOf(100f) }
         DetailMovieInformation(
             movie = state.movie,
             modifier = Modifier
                 .align(Alignment.BottomCenter)
                 .offset(y = offsetY.dp)
                 .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                       change.consume()
                       offsetY = (offsetY + (dragAmount.y / 2))
                           .coerceIn(-300f, 100f)
                    }
                 }
         )

         Box(
             modifier = Modifier
                 .fillMaxSize()
                 .background(
                     Brush.verticalGradient(
                         colors = listOf(
                             Color.Transparent,
                             Color.Transparent,
                             Color.Transparent,
                             Color.Transparent,
                             Color.Black.copy(alpha = 0.7f)
                         )
                     )
                 )
         )
      }

      IconButton(onClick = { onBack() }, modifier = Modifier.align(Alignment.TopStart)) {
         Icon(
             imageVector = Icons.Default.ArrowBack,
             contentDescription = "back",
             tint = Color.Yellow
         )
      }
      if (state.isLoading) {
         CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
      }
   }
}

