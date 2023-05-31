package com.example.listadepeliculas.ui.home.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listadepeliculas.R

/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 */

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier
) {
   Box(
       modifier = modifier
           .fillMaxWidth()
           .height(60.dp),
       contentAlignment = Alignment.Center
   ) {
      Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.Center
      ) {
         Image(
             painterResource(id = R.drawable.movie1),
             contentDescription = null,
             modifier = Modifier
                 //.padding(vertical = 30.dp)
                 .size(50.dp)
                 .padding(end = 10.dp)
         )
         Text(
             text = "Фильмы",
             color = Color.White,
             fontWeight = FontWeight.ExtraBold,
             fontSize = 30.sp,
             textAlign = TextAlign.Center
         )
      }

   }
}