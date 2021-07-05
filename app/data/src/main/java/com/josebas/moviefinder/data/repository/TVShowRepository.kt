package com.josebas.moviefinder.data.repository

import com.josebas.moviefinder.data.datasource.local.InMemoryTVShowDataSource
import com.josebas.moviefinder.domain.local.TVShow

class TVShowRepository(private val inMemoryTVShowRepository: InMemoryTVShowDataSource) {

    fun getPopularTVShow(): List<TVShow> = inMemoryTVShowRepository.getTVShow()
}