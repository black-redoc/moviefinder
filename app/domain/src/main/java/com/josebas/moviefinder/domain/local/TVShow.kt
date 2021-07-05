package com.josebas.moviefinder.domain.local

import com.josebas.moviefinder.domain.Genre
import java.time.LocalDate

data class TVShow(
    override val id: Int,
    override val originalLanguage: String,
    val originalName: String,
    override val overview: String,
    val popularity: Float,
    override val posterPath: String?,
    override val backdropPath: String?,
    val firstAirDate: LocalDate,
    override val genres: List<Genre>
) : MotionPicture
