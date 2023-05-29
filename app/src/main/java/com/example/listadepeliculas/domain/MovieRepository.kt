package com.example.listadepeliculas.domain

import com.example.listadepeliculas.domain.model.Movie

/**
 * @author : Mingaleev D
 * @data : 29.05.2023
 */

interface MovieRepository {

   suspend fun getUpcomingMovie():List<Movie>
}