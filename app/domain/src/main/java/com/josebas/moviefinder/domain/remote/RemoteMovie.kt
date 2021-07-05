package com.josebas.moviefinder.domain.remote

data class RemoteMovie(
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val id: Int,
    val original_title: String,
    val original_language: String,
    val overview: String,
    val poster_path: String?,
    val release_date: String?
)