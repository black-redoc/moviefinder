package com.josebas.moviefinder.domain

import java.time.LocalDate

data class Movie(
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val releaseDate: LocalDate,
    val posterPath: String?,
    val backdropPath: String?,
    val genres: List<Genre>
)