package com.example.listadepeliculas.data.remote.api

import com.example.listadepeliculas.data.common.Constants.BASE_API_KEY
import com.example.listadepeliculas.data.common.Constants.END_POINT_POPULAR
import com.example.listadepeliculas.data.common.Constants.END_POINT_UPCOMING
import com.example.listadepeliculas.data.common.Constants.FILTER_DIS
import com.example.listadepeliculas.data.common.Constants.LANGUAGE_EN
import com.example.listadepeliculas.data.common.Constants.LANGUAGE_ES
import com.example.listadepeliculas.data.common.Constants.SORT_BY
import com.example.listadepeliculas.data.remote.dto.MovieDtoResponse
import com.example.listadepeliculas.data.remote.dto.details.DetailsDtoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
 */

interface ApiService {

   @GET(END_POINT_UPCOMING)
   suspend fun getUpcomingMovie(
       @Query("api_key") apiKey: String = BASE_API_KEY,
       @Query("language") language: String = "ru-RU",
   ): MovieDtoResponse

   @GET(END_POINT_POPULAR)
   suspend fun getPopularMovie(
       @Query("api_key") apiKey: String = BASE_API_KEY,
       @Query("language") language: String = "ru-RU",
   ): MovieDtoResponse

   @GET(FILTER_DIS)
   suspend fun getMovieEngFilter(
       @Query("api_key") apiKey: String = BASE_API_KEY,
       @Query("sort_by") SortBy: String = SORT_BY,
       @Query("original_language") origLang: String = LANGUAGE_EN,
       @Query("with_original_language") withOrigLang: String,
   ): MovieDtoResponse

   @GET(FILTER_DIS)
   suspend fun getMovieEsFilter(
       @Query("api_key") apiKey: String = BASE_API_KEY,
       @Query("sort_by") SortBy: String = SORT_BY,
       @Query("original_language") origLang: String = LANGUAGE_ES,
       @Query("with_original_language") withOrigLang: String,
   ): MovieDtoResponse

   @GET("movie/{movie_id}")
   suspend fun getDetailsByIdMovie(
       @Path("movie_id") movieId: Int,
       @Query("api_key") apiKey: String = BASE_API_KEY,
       @Query("language") language: String = "ru-RU",
   ): DetailsDtoResponse
}