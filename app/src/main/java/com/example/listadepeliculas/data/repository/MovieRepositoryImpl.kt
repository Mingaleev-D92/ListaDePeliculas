package com.example.listadepeliculas.data.repository

import com.example.listadepeliculas.data.common.extensions.resultOf
import com.example.listadepeliculas.data.local.MovieDao
import com.example.listadepeliculas.data.local.entities.MovieEntity
import com.example.listadepeliculas.data.local.entities.MovieType
import com.example.listadepeliculas.data.remote.api.ApiService
import com.example.listadepeliculas.data.remote.mapper.toDomain
import com.example.listadepeliculas.data.remote.mapper.toEntity
import com.example.listadepeliculas.domain.MovieRepository
import com.example.listadepeliculas.domain.model.FilterType
import com.example.listadepeliculas.domain.model.Movie
import com.example.listadepeliculas.domain.model.MovieList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
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

//   override fun getUpcomingMovie(): Flow<List<Movie>> {
//      return flow {
//         val localMovies = dao.getMovies().filter { it.type == MovieType.UPCOMING }
//         emit(localMovies.map { it.toDomain() })
//         getUpcomingMoviesRemote().onSuccess {
//            emit(it)
//         }.onFailure {
//            println()
//         }
//      }
//   }

   private suspend fun getPopularMovieRemote() = resultOf {
      val results = api.getPopularMovie().results
      val movies = results.map { it.toDomain() }
     // movies.forEach { dao.insertMovie(it.toEntity(MovieType.TRENDING_POPULAR)) }
      movies
   }

//   override fun getPopularMovie(): Flow<List<Movie>> {
//      return flow {
//         val localMovies = dao.getMovies().filter { it.type == MovieType.TRENDING_POPULAR }
//         emit(localMovies.map { it.toDomain() })
//         getPopularMovieRemote().onSuccess {
//            emit(it)
//         }.onFailure {
//            println()
//         }
//      }
//   }

   private suspend fun getMovieEngFilterRemote(withOrigLang: String) = resultOf {
      val results = api.getMovieEngFilter(withOrigLang = withOrigLang).results
      val movies = results.map { it.toDomain() }
      //movies.forEach { dao.insertMovie(it.toEntity(MovieType.ENGLISH_LANG)) }
      movies
   }

//   override fun getMovieEngFilter(withOrigLang: String): Flow<List<Movie>> {
//      return flow {
//         val localMovies = dao.getMovies().filter { it.type == MovieType.ENGLISH_LANG }
//         emit(localMovies.map { it.toDomain() })
//         getMovieEngFilterRemote(withOrigLang = withOrigLang).onSuccess {
//            emit(it)
//         }.onFailure {
//            println()
//         }
//      }
//   }

   private suspend fun getMovieEsFilterRemote(withOrigLang: String) = resultOf {
      val results = api.getMovieEsFilter(withOrigLang = withOrigLang).results
      val movies = results.map { it.toDomain() }
      movies.forEach { dao.insertMovie(it.toEntity(MovieType.SPAIN_LANG)) }
      movies
   }

//   override fun getMovieEsFilter(withOrigLang: String): Flow<List<Movie>> {
//      return flow {
//         val localMovies = dao.getMovies().filter { it.type == MovieType.SPAIN_LANG }
//         emit(localMovies.map { it.toDomain() })
//         getMovieEsFilterRemote(withOrigLang = withOrigLang).onSuccess {
//            emit(it)
//         }.onFailure {
//            println()
//         }
//      }
//   }

   //---------------------------------------------------------

   override fun getAllMovies(filterType: FilterType): Flow<MovieList> {
      return flow {
         emit(getMovieListLocal(filterType))

         getUpcomingMoviesRemote().onSuccess {
            saveMoviesLocal(it, MovieType.UPCOMING)
            emit(getMovieListLocal(filterType))
         }.onFailure {
            println()
         }
         getPopularMovieRemote().onSuccess {
            saveMoviesLocal(it, MovieType.TRENDING_POPULAR)
            emit(getMovieListLocal(filterType))
         }.onFailure {
            println()
         }
      }
   }

   private suspend fun saveMoviesLocal(movies: List<Movie>, movieType: MovieType) {
      movies.forEach { dao.insertMovie(it.toEntity(movieType)) }
   }

   private suspend fun getMovieListLocal(filterType: FilterType): MovieList {
      val localMovies = dao.getMovies()
      val movieTypeFromFilter = when (filterType) {
         FilterType.ENGLISH -> MovieType.ENGLISH_LANG
         FilterType.RELEASED -> MovieType.SPAIN_LANG
      }
      return MovieList(
          upcoming = filterAndMapMovie(movies = localMovies, movieType = MovieType.UPCOMING),
          popular = filterAndMapMovie(
              movies = localMovies,
              movieType = MovieType.TRENDING_POPULAR
          ),
          filtered = filterAndMapMovie(movies = localMovies, movieType = movieTypeFromFilter)
      )
   }

   private fun filterAndMapMovie(movieType: MovieType, movies: List<MovieEntity>): List<Movie> {
      return movies.filter { it.type == movieType }.map { it.toDomain() }
   }
}