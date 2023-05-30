package com.example.listadepeliculas.ui.home.screen.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 */

@Composable
fun CategoryTitle(
    title:String,
    modifier:Modifier = Modifier
) {
   Text(
       text = title,
       fontWeight = FontWeight.SemiBold,
       fontSize = 20.sp,
       color = Color.White,
       modifier = modifier
   )
}