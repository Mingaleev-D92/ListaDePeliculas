package com.example.listadepeliculas.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listadepeliculas.ui.home.screen.HomeScreen
import com.example.listadepeliculas.ui.theme.BlackBack
import com.example.listadepeliculas.ui.theme.ListaDePeliculasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         ListaDePeliculasTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = BlackBack
            ) {
               val navController = rememberNavController()
               NavHost(navController = navController, startDestination = "Home") {
                  composable(route = "Home") {
                     HomeScreen()
                  }
               }

            }
         }
      }
   }
}