package com.josebas.moviefinder.data.repository

import com.josebas.moviefinder.data.datasource.InMemoryMovieDataSource
import com.josebas.moviefinder.domain.Movie

class MovieRepository {
    private val inMemoryMovieDataSource = InMemoryMovieDataSource()

    fun getPopularMovies(): List<Movie> = inMemoryMovieDataSource.getMovies()
}