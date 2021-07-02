package com.josebas.moviefinder.domain

data class TVShow(
    override val id: Int,
    override val originalLanguage: String,
    val originalName: String,
    override val overview: String,
    val popularity: Float,
    override val posterPath: String?,
    override val backdropPath: String?,
    override val genres: List<Genre>
) : MotionPicture
