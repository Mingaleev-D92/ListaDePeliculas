package com.example.listadepeliculas.domain

import com.example.listadepeliculas.domain.model.Movie
import kotlinx.coroutines.flow.Flow

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
 */

interface MovieRepository {
   fun getUpcomingMovie(): Flow<List<Movie>>
   fun getPopularMovie(): Flow<List<Movie>>
   fun getMovieEngFilter(withOrigLang: String): Flow<List<Movie>>
   fun getMovieEsFilter(withOrigLang: String): Flow<List<Movie>>
}