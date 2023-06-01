package com.example.listadepeliculas.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.listadepeliculas.ui.details.screen.DetailsScreen
import com.example.listadepeliculas.ui.home.screen.HomeScreen
import com.example.listadepeliculas.ui.theme.BlackBack
import com.example.listadepeliculas.ui.theme.ListaDePeliculasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      installSplashScreen()
      setContent {
         ListaDePeliculasTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = BlackBack
            ) {
               val navController = rememberNavController()
               NavHost(navController = navController, startDestination = "Home") {
                  composable(route = "Home") {
                     HomeScreen(onMovieClick = {
                        navController.navigate("DETAIL/${it.id}")
                     })
                  }
                  composable("DETAIL/{movie_id}", arguments = listOf(
                      navArgument("movie_id") {
                         type = NavType.IntType
                      }
                  )) {
                     DetailsScreen() {
                        navController.popBackStack()
                     }
                  }
               }

            }
         }
      }
   }
}