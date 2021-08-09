package com.josebas.moviefinder.data.repository

import com.josebas.moviefinder.data.common.toLocalMovies
import com.josebas.moviefinder.data.datasource.remote.RemoteMovieDataSource
import com.josebas.moviefinder.domain.common.GenresDataSource
import com.josebas.moviefinder.domain.local.Movie

class MovieRepositoryImpl(
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val genresDataSource: GenresDataSource
): MovieRepository {

    override suspend fun getPopularMovies(): List<Movie>  = with(remoteMovieDataSource.getPopularMovies()) {
        return results.toLocalMovies(genresDataSource)
    }

    override suspend fun getRatedMovies(): List<Movie> = with(remoteMovieDataSource.getTopRatedMovies()) {
        return results.toLocalMovies(genresDataSource)
    }

    override suspend fun getUpComingMovies(): List<Movie> = with(remoteMovieDataSource.getUpComingMovies()) {
        return results.toLocalMovies(genresDataSource)
    }
}