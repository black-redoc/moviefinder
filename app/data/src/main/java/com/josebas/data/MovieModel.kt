package com.josebas.data

import java.util.*

data class MovieModel(
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val release_date: Date,
    val home_page: String?,
    val poster_pat: String?,
    val backdrop_path: String?,
    val genres: List<GenresModel>
)
