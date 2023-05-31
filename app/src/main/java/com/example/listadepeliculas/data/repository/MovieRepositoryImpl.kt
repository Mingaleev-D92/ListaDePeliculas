package com.example.listadepeliculas.data.repository

import com.example.listadepeliculas.data.common.extensions.resultOf
import com.example.listadepeliculas.data.local.MovieDao
import com.example.listadepeliculas.data.local.entities.MovieType
import com.example.listadepeliculas.data.remote.api.ApiService
import com.example.listadepeliculas.data.remote.mapper.toDomain
import com.example.listadepeliculas.data.remote.mapper.toEntity
import com.example.listadepeliculas.domain.MovieRepository
import com.example.listadepeliculas.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
 * оставил для себя как сравнения
 *   return try {
//   val resut = api.getUpcomingMovie().results
//   Result.success(resut.map { it.toDomain() })
// } catch (e: Exception) {
//    Result.failure(e)
// }
// }
 */

class MovieRepositoryImpl(
    private val api: ApiService,
    private val dao: MovieDao
) : MovieRepository {

   private suspend fun getUpcomingMoviesRemote() = resultOf {
      val results = api.getUpcomingMovie().results
      val movies = results.map { it.toDomain() }
      movies.forEach { dao.insertMovie(it.toEntity(MovieType.UPCOMING)) }
      movies
   }

   override fun getUpcomingMovie(): Flow<List<Movie>> {
      return flow {
         val localMovies = dao.getMovies().filter { it.type == MovieType.UPCOMING }
         emit(localMovies.map { it.toDomain() })
         getUpcomingMoviesRemote().onSuccess {
            emit(it)
         }.onFailure {
            println()
         }
      }
   }

   override suspend fun getPopularMovie() = resultOf {
      val results = api.getPopularMovie().results
      results.map { it.toDomain() }
   }

   override suspend fun getMovieEngFilter(withOrigLang: String) = resultOf {
      val results = api.getMovieEngFilter(withOrigLang = withOrigLang).results
      results.map { it.toDomain() }
   }

   override suspend fun getMovieEsFilter(withOrigLang: String) = resultOf {
      val results = api.getMovieEsFilter(withOrigLang = withOrigLang).results
      results.map { it.toDomain() }
   }
}