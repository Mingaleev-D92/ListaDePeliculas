package com.example.listadepeliculas.data.remote.api

import com.example.listadepeliculas.BuildConfig
import com.example.listadepeliculas.data.common.Constants.BASE_API_KEY
import com.example.listadepeliculas.data.common.Constants.END_POINT
import com.example.listadepeliculas.data.remote.dto.MovieDtoResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
 */

interface ApiService {

   @GET(END_POINT)
   suspend fun getUpcomingMovie(
       @Query("api_key") apiKey: String = BASE_API_KEY,
       @Query("language") language: String = "ru-RU",
   ): MovieDtoResponse
}