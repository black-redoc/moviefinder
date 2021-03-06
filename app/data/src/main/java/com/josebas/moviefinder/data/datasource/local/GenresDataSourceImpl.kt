package com.josebas.moviefinder.data.datasource.local

import com.josebas.moviefinder.domain.Genre
import com.josebas.moviefinder.domain.common.GenresDataSource

class GenresDataSourceImpl: GenresDataSource {
     private val genres = listOf(
        Genre(28, "Action"),
        Genre(12, "Adventure"),
        Genre(16, "Animation"),
        Genre(35,"Comedy"),
        Genre(80, "Crime"),
        Genre(99, "Documentary"),
        Genre(18, "Drama"),
        Genre(10751, "Family"),
        Genre(14, "Fantasy"),
        Genre(36, "History"),
        Genre(27, "Horror"),
        Genre( 10402, "Music"),
        Genre(9648, "Mystery"),
        Genre(10749, "Romance"),
        Genre(878, "Science Fiction"),
        Genre(10770, "TV Movie"),
        Genre(53, "Thriller"),
        Genre(10752, "War"),
        Genre(37, "Western")
    )

    override fun getLocalGenres() : List<Genre> = genres
}