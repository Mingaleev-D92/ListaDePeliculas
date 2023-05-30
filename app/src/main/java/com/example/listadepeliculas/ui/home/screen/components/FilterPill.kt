package com.example.listadepeliculas.ui.home.screen.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listadepeliculas.ui.theme.ListaDePeliculasTheme

/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 */

@Composable
fun FilterPill(
    type: FilterType,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

   val backgroundColor = if (isSelected) Color.Black else Color.White
   val textColor = if (isSelected) Color.White else Color.Black

   Box(
       modifier = modifier
           .clip(RoundedCornerShape(20.dp))
           .clickable {
              onClick()
           }
           .background(backgroundColor)
           .then(
               if (isSelected) {
                  modifier.border((0.5).dp, color = Color.White, RoundedCornerShape(20.dp))
               } else {
                  modifier
               }
           )

           .padding(vertical = 8.dp)
           .width(100.dp),
       contentAlignment = Alignment.Center
   ) {
      Text(
          text = type.nameText,
          fontSize = 18.sp,
          color = textColor
      )
   }
}

@Preview
@Composable
fun PreviewFilterPill() {
   ListaDePeliculasTheme() {
      FilterPill(type = FilterType.ENGLISH, isSelected = true) {

      }
   }
}