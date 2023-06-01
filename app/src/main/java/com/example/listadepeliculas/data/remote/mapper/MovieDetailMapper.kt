package com.example.listadepeliculas.data.remote.mapper

import com.example.listadepeliculas.data.common.Constants.POSTER_POINT
import com.example.listadepeliculas.data.remote.dto.details.DetailsDtoResponse
import com.example.listadepeliculas.domain.model.MovieDetail

/**
 * @author : Mingaleev D
 * @data : 01.06.2023
 */

fun DetailsDtoResponse.toDomain(): MovieDetail {
   return MovieDetail(
       id = this.id,
       image = POSTER_POINT + this.posterPath,
       name = this.title,
       year = this.releaseDate,
       language = this.originalLanguage,
       rating = String.format("%.1f", this.voteAverage).toDouble(),
       genres = this.genres.map { it.name },
       description = this.overview
   )

}