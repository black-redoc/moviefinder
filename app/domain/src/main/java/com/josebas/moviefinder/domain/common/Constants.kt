package com.josebas.moviefinder.domain.common

import com.josebas.moviefinder.domain.Genre
import com.josebas.moviefinder.domain.datasource.GenresDataSource
import java.time.LocalDate

const val baseImageUrl = "https://image.tmdb.org/t/p/w500"

fun String.toLocalDate(): LocalDate = LocalDate.parse(this)

fun List<Int>.findGenres(genresDataSource: GenresDataSource): List<Genre> = this.map {
    genresDataSource.getGenres().find { genre -> it == genre.id } ?: Genre(0, "No genre found")
}