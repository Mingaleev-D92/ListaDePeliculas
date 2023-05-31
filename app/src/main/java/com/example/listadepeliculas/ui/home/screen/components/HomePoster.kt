package com.example.listadepeliculas.ui.home.screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

/**
 * @author : Mingaleev D
 * @data : 31.05.2023
 */

@Composable
fun HomePoster(
    imageUrl: String,
    posterSize: MoviePosterSize
) {

   val height = if(posterSize == MoviePosterSize.SMALL) 180 else 205
   val width = if(posterSize == MoviePosterSize.SMALL) 138 else 156

   AsyncImage(
       model = ImageRequest.Builder(LocalContext.current)
           .data(imageUrl)
           .crossfade(true)
           .build(),
       contentDescription = null,
       modifier = Modifier
           .size(width = (width).dp, height = (height).dp)
           .clip(RoundedCornerShape(8.dp)),
       contentScale = ContentScale.FillBounds
   )
}

enum class MoviePosterSize() {
   SMALL,
   BIG
}