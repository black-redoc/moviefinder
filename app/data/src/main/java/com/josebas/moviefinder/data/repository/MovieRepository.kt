package com.josebas.moviefinder.data.repository

import com.josebas.moviefinder.domain.local.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getRatedMovies(): List<Movie>
    suspend fun getUpComingMovies(): List<Movie>
}