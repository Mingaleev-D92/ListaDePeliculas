package com.example.listadepeliculas.domain

import com.example.listadepeliculas.domain.model.Movie

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
 */

interface MovieRepository {
   suspend fun getUpcomingMovie(): Result<List<Movie>>
   suspend fun getPopularMovie(): Result<List<Movie>>
   suspend fun getMovieEngFilter(withOrigLang: String): Result<List<Movie>>
   suspend fun getMovieEsFilter(withOrigLang: String): Result<List<Movie>>
}