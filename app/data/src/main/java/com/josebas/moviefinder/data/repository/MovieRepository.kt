package com.josebas.moviefinder.data.repository

import com.josebas.moviefinder.domain.local.Movie

interface MovieRepository {
    fun getPopularMovies(): List<Movie>
    suspend fun getRatedMovies(): List<Movie>
}