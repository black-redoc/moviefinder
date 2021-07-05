package com.josebas.moviefinder.data.repository

import com.josebas.moviefinder.domain.local.TVShow

interface TVShowRepository {
    suspend fun getPopularTVShow(): List<TVShow>
}