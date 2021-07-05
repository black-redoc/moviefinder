package com.josebas.moviefinder.domain.remote

data class RemoteTVShow(
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val id: Int,
    val overview: String,
    val poster_path: String?,
    val first_air_date: String?,
    val original_name: String,
    val original_language: String,
    val popularity: Float
)
