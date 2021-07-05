package com.josebas.moviefinder.domain.local

import com.josebas.moviefinder.domain.Genre
import java.time.LocalDate

data class Movie(
    override val id: Int,
    override val originalLanguage: String,
    val originalTitle: String,
    override val overview: String,
    val releaseDate: LocalDate,
    override val posterPath: String?,
    override val backdropPath: String?,
    override val genres: List<Genre>
) : MotionPicture