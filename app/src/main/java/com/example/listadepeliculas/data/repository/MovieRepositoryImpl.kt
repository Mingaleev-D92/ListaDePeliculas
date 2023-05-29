package com.example.listadepeliculas.data.repository

import com.example.listadepeliculas.data.remote.api.ApiService
import com.example.listadepeliculas.data.remote.mapper.toDomain
import com.example.listadepeliculas.domain.MovieRepository
import com.example.listadepeliculas.domain.model.Movie

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
 */

class MovieRepositoryImpl(
    private val api: ApiService
) : MovieRepository {
   override suspend fun getUpcomingMovie(): List<Movie> {
      return api.getUpcomingMovie().results.map { it.toDomain() }
   }
}