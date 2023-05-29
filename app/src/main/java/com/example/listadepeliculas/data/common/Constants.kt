package com.example.listadepeliculas.data.common

import com.example.listadepeliculas.BuildConfig

//https://api.themoviedb.org/3/movie/upcoming?api_key=&language=ru-RU

object Constants {

   const val BASE_API_KEY = BuildConfig.API_KEY
   const val BASE_URL = "https://api.themoviedb.org/3/"
   const val END_POINT = "movie/upcoming"
   const val POSTER_POINT = "https://image.tmdb.org/t/p/w500"
}