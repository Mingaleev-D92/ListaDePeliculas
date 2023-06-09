package com.example.listadepeliculas.data.remote.mapper

import com.example.listadepeliculas.data.common.Constants.POSTER_POINT
import com.example.listadepeliculas.data.remote.dto.ResultM
import com.example.listadepeliculas.domain.model.Movie

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
 */

fun ResultM.toDomain(): Movie {
   return Movie(
       description = this.overview,
       title = this.title,
       releaseDate = this.releaseDate.substring(0, 4),
       originalLanguage = this.originalLanguage,
       rating = this.voteAverage,
       poster = POSTER_POINT + this.posterPath,
       genres = this.genreIds
   )


}