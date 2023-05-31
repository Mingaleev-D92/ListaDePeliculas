package com.example.listadepeliculas.data.common

import com.example.listadepeliculas.BuildConfig

object Constants {

   const val BASE_API_KEY = BuildConfig.API_KEY
   const val BASE_URL = "https://api.themoviedb.org/3/"
   const val END_POINT_UPCOMING = "movie/upcoming"
   const val END_POINT_POPULAR= "movie/popular"
   const val POSTER_POINT = "https://image.tmdb.org/t/p/w500"
   const val FILTER_DIS = "discover/movie"
   const val SORT_BY = "popularity.desc"
   const val LANGUAGE_EN = "en"
   const val LANGUAGE_ES = "es"
   const val COUNT_IN_GRID = 2
}