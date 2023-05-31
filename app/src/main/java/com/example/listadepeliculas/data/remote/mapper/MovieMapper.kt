package com.example.listadepeliculas.data.remote.mapper

import com.example.listadepeliculas.data.common.Constants.POSTER_POINT
import com.example.listadepeliculas.data.local.entities.MovieEntity
import com.example.listadepeliculas.data.local.entities.MovieType
import com.example.listadepeliculas.data.remote.dto.ResultM
import com.example.listadepeliculas.domain.model.Movie

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
 */

fun ResultM.toDomain(): Movie {
   return Movie(
       id = this.id,
       poster = POSTER_POINT + this.posterPath,
//       description = this.overview,
//       title = this.title,
//       releaseDate = this.releaseDate,//.substring(0, 4).toInt(),
//       originalLanguage = this.originalLanguage,
//       rating = this.voteAverage,
//       genres = this.genreIds
   )
}
fun Movie.toEntity(type:MovieType):MovieEntity{
   return MovieEntity(
       id = this.id,
       poster = this.poster,
       type = type
   )
}
fun MovieEntity.toDomain():Movie{
   return Movie(
       id = this.id,
       poster = this.poster,
   )
}