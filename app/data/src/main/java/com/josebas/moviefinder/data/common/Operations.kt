package com.josebas.moviefinder.data.common

import com.josebas.moviefinder.domain.Genre
import com.josebas.moviefinder.domain.common.GenresDataSource
import com.josebas.moviefinder.domain.common.baseImageUrl
import com.josebas.moviefinder.domain.common.findGenres
import com.josebas.moviefinder.domain.common.toLocalDate
import com.josebas.moviefinder.domain.local.Movie
import com.josebas.moviefinder.domain.remote.RemoteMovie


fun RemoteMovie.toLocalMovie(genresDataSource: GenresDataSource): Movie = Movie(
    id,
    original_language,
    original_title,
    overview,
    release_date!!.toLocalDate(),
    "$baseImageUrl/$poster_path",
    "$baseImageUrl/$backdrop_path",
    genres_ids?.findGenres(genresDataSource) ?: listOf<Genre>()
)

fun List<RemoteMovie>.toLocalMovies(
    genresDataSource: GenresDataSource
): List<Movie> = asSequence().map { it.toLocalMovie(genresDataSource) }.toList()
