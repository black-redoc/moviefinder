package com.josebas.moviefinder.domain

data class Serie(
    val id: Int,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Float,
    val posterPath: String?,
    val genres: List<Genre>
)
