package com.josebas.moviefinder.data.repository

import com.josebas.moviefinder.data.datasource.local.InMemoryMovieDataSource
import com.josebas.moviefinder.data.common.toLocalMovies
import com.josebas.moviefinder.data.datasource.remote.RemoteMovieDataSource
import com.josebas.moviefinder.domain.common.GenresDataSource
import com.josebas.moviefinder.domain.local.Movie

class MovieRepositoryImpl(
    private val inMemoryDataSource: InMemoryMovieDataSource,
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val genresDataSource: GenresDataSource
): MovieRepository {

    override fun getPopularMovies(): List<Movie>  = inMemoryDataSource.getMovies()

    override suspend fun getRatedMovies(): List<Movie> = with(remoteMovieDataSource.getTopRatedMovies()) {
        return results.toLocalMovies(genresDataSource)
    }
}