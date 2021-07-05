package com.josebas.moviefinder.data.common

import com.josebas.moviefinder.domain.common.GenresDataSource
import com.josebas.moviefinder.domain.common.baseImageUrl
import com.josebas.moviefinder.domain.common.findGenres
import com.josebas.moviefinder.domain.common.toLocalDate
import com.josebas.moviefinder.domain.local.Movie
import com.josebas.moviefinder.domain.local.TVShow
import com.josebas.moviefinder.domain.remote.RemoteMovie
import com.josebas.moviefinder.domain.remote.RemoteTVShow


fun RemoteTVShow.toLocalTVShow(genresDataSource: GenresDataSource): TVShow = TVShow(
    id,
    original_language,
    original_name,
    overview,
    popularity,
    "$baseImageUrl/$poster_path",
    "$baseImageUrl/$backdrop_path",
    first_air_date!!.toLocalDate(),
    genre_ids?.findGenres(genresDataSource) ?: listOf()
)

fun RemoteMovie.toLocalMovie(genresDataSource: GenresDataSource): Movie = Movie(
    id,
    original_language,
    original_title,
    overview,
    release_date!!.toLocalDate(),
    "$baseImageUrl/$poster_path",
    "$baseImageUrl/$backdrop_path",
    genre_ids?.findGenres(genresDataSource) ?: listOf()
)

fun List<RemoteTVShow>.toLocalTVShows(
    genresDataSource: GenresDataSource
): List<TVShow> = map { it.toLocalTVShow(genresDataSource) }

fun List<RemoteMovie>.toLocalMovies(
    genresDataSource: GenresDataSource
): List<Movie> = asSequence().map { it.toLocalMovie(genresDataSource) }.toList()
