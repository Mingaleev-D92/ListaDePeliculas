package com.example.listadepeliculas.domain

import com.example.listadepeliculas.domain.model.FilterType
import com.example.listadepeliculas.domain.model.Movie
import com.example.listadepeliculas.domain.model.MovieDetail
import com.example.listadepeliculas.domain.model.MovieList
import kotlinx.coroutines.flow.Flow

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
 */

interface MovieRepository {
   fun getAllMovies(filterType: FilterType, isFilterOnly: Boolean): Flow<MovieList>
   suspend fun getMovieById(id: Int): Result<MovieDetail>
}