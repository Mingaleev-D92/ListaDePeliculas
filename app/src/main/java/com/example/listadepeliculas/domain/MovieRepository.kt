package com.example.listadepeliculas.domain

import com.example.listadepeliculas.domain.model.Movie
import kotlinx.coroutines.flow.Flow

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
 */

interface MovieRepository {
   fun getUpcomingMovie(): Flow<List<Movie>>
   suspend fun getPopularMovie(): Result<List<Movie>>
   suspend fun getMovieEngFilter(withOrigLang: String): Result<List<Movie>>
   suspend fun getMovieEsFilter(withOrigLang: String): Result<List<Movie>>
}